package dk.signfluent.service.bpm.service;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.ApprovalOrderModel;
import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.service.bpm.mapper.DocumentMapper;
import dk.signfluent.service.bpm.model.DocumentWithContent;
import dk.signfluent.service.bpm.model.request.*;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.bpm.provider.ProcessDetailsProvider;
import dk.signfluent.service.bpm.provider.TaskDetailsProvider;
import dk.signfluent.service.bpm.utility.ProcessFormKey;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.model.User;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

import static dk.signfluent.service.bpm.utility.ProcessVariables.*;
import static dk.signfluent.service.bpm.utility.Processes.SIGNING_PROCESS;


@Service
public class DocumentService {
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final DocumentServiceApiProvider documentServiceApiProvider;
    private final UserServiceApiProvider userServiceApiProvider;
    private final DocumentMapper documentMapper;
    private final TaskDetailsProvider taskDetailsProvider;
    private final ProcessDetailsProvider processDetailsProvider;

    public DocumentService(RuntimeService runtimeService, TaskService taskService, DocumentServiceApiProvider documentServiceApiProvider, UserServiceApiProvider userServiceApiProvider, DocumentMapper documentMapper, TaskDetailsProvider taskDetailsProvider, ProcessDetailsProvider processDetailsProvider) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.documentServiceApiProvider = documentServiceApiProvider;
        this.userServiceApiProvider = userServiceApiProvider;
        this.documentMapper = documentMapper;
        this.taskDetailsProvider = taskDetailsProvider;
        this.processDetailsProvider = processDetailsProvider;
    }

    public void inspectDocument(InspectDocumentRequest inspectDocumentRequest) {
        Task inspectDocumentTask = processDetailsProvider.getFirstTaskForProcessInstanceAndFormKey(inspectDocumentRequest.getProcessId(), ProcessFormKey.INSPECT_DOCUMENT);
        taskService.complete(inspectDocumentTask.getId(), getProcessVariablesForInspectDocument(inspectDocumentRequest));
    }

    public void approveDocument(ApproveDocumentRequest approveDocumentRequest) {
        Task approveDocumentTask = processDetailsProvider.getFirstTaskForProcessInstanceFormKeyAndAssignee(approveDocumentRequest.getProcessId(), ProcessFormKey.APPROVE_DOCUMENT, approveDocumentRequest.getApproverId());
        taskService.complete(approveDocumentTask.getId(), getProcessVariablesForApproveDocument(approveDocumentRequest));
    }


    public void assignApprovers(AssignApproversRequest assignApproversRequest) {
        Task assignApproversTask = processDetailsProvider.getFirstTaskForProcessInstanceAndFormKey(assignApproversRequest.getProcessId(), ProcessFormKey.ASSIGN_APPROVERS);
        try {
            documentServiceApiProvider.assignApprovers(createAssignApproversRequest(assignApproversRequest));
            taskService.complete(assignApproversTask.getId(), getProcessVariablesForAssignApprovers(assignApproversRequest));
        } catch (Exception e) {
            taskService.handleBpmnError(assignApproversTask.getId(), "-1", "Failed to assign approvers " + e);
        }
    }

    public void uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws ApiException {
        String uploadedDocumentId = documentServiceApiProvider.uploadDocument(uploadDocumentRequest.getUserId(), uploadDocumentRequest.getDescription(), uploadDocumentRequest.getDocument());
        runtimeService.startProcessInstanceByKey(SIGNING_PROCESS, uploadedDocumentId, Collections.singletonMap(DOCUMENT_ID, uploadedDocumentId));
    }

    public List<DocumentResponse> getDocumentsForInspection() throws Exception {
        List<ProcessInstance> processInstancesWithFormKey = processDetailsProvider.getProcessInstancesWithFormKey(ProcessFormKey.INSPECT_DOCUMENT);
        return taskDetailsProvider.appendDocumentsInformationToTask(processInstancesWithFormKey);
    }

    public List<DocumentResponse> getDocumentsForApproval(UserBasedRequest userBasedRequest) throws Exception {
        List<ProcessInstance> processInstancesWithFormKey = processDetailsProvider.getProcessInstancesWithFormKeyAndAssignee(ProcessFormKey.APPROVE_DOCUMENT, userBasedRequest.getUserId());
        return taskDetailsProvider.appendDocumentsInformationToTask(processInstancesWithFormKey);
    }
    public List<DocumentResponse> getSignDocumentsTasks(UserBasedRequest userBasedRequest) throws Exception {
        List<ProcessInstance> processInstancesWithFormKey = processDetailsProvider.getProcessInstancesWithFormKeyAndAssignee(ProcessFormKey.SIGN_DOCUMENT, userBasedRequest.getUserId());

        return taskDetailsProvider.appendDocumentsInformationToTask(processInstancesWithFormKey);
    }

    public DocumentWithContent getDocumentDetails(String processId) {
        String documentId = extractDocumentIdFromProcessId(processId);
        try {
            DocumentContent documentDetails = documentServiceApiProvider.getDocumentDetails(documentId);
            Assert.notNull(documentDetails.getUploaderId(), "Uploader ID is not present");
            DocumentWithContent documentWithContent = documentMapper.mapDocumentWithContent(documentDetails);
            documentWithContent.setUploadedBy(getUploaderDetails(documentDetails.getUploaderId().toString()));
            return documentWithContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    private Map<String, Object> getProcessVariablesForAssignApprovers(AssignApproversRequest assignApproversRequest) {
        List<String> approversInOrder = assignApproversRequest.getApprovers().stream()
                .map(ApprovalOrderModel::getApproverId)
                .filter(Objects::nonNull)
                .map(UUID::toString)
                .collect(Collectors.toList());
        return Collections.singletonMap(APPROVERS, approversInOrder);
    }

    @NotNull
    private Map<String, Object> getProcessVariablesForInspectDocument(InspectDocumentRequest inspectDocumentRequest) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(IS_DOCUMENT_VALID, inspectDocumentRequest.getIsValid());
        variables.put(DELEGATOR_ID, inspectDocumentRequest.getDelegatorId());
        return variables;
    }

    @NotNull
    private Map<String, Object> getProcessVariablesForApproveDocument(ApproveDocumentRequest approveDocumentRequest) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(IS_APPROVED, approveDocumentRequest.isApprove());
        return variables;
    }

    private User getUploaderDetails(String uploaderId) throws Exception {
        return userServiceApiProvider.getUsersByIds(Collections.singletonList(uploaderId)).get(0);
    }

    private AssignApprovers createAssignApproversRequest(AssignApproversRequest assignApproversRequest) {
        AssignApprovers assignApprovers = new AssignApprovers();
        assignApprovers.setApprovers(assignApproversRequest.getApprovers());
        assignApprovers.setDelegatorId(UUID.fromString(assignApproversRequest.getDelegatorId()));
        assignApprovers.setDocumentId(UUID.fromString(extractDocumentIdFromProcessId(assignApproversRequest.getProcessId())));
        return assignApprovers;
    }

    private String extractDocumentIdFromProcessId(String processId) {
        return processDetailsProvider.getProcessInstanceById(processId).getBusinessKey();
    }
}
