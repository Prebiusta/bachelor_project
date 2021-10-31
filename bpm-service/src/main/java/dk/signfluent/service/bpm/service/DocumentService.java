package dk.signfluent.service.bpm.service;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.service.bpm.mapper.DocumentMapper;
import dk.signfluent.service.bpm.model.*;
import dk.signfluent.service.bpm.model.request.InspectDocumentRequest;
import dk.signfluent.service.bpm.model.request.UploadDocumentRequest;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.bpm.provider.TaskDetailsProvider;
import dk.signfluent.service.bpm.provider.UserProvider;
import dk.signfluent.service.bpm.utility.ProcessFormKey;
import dk.signfluent.service.bpm.utility.ProcessTaskUtils;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.model.User;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

import static dk.signfluent.service.bpm.utility.ProcessVariables.*;
import static dk.signfluent.service.bpm.utility.Processes.SIGNING_PROCESS;


@Service
public class DocumentService {
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final ProcessTaskUtils processTaskUtils;
    private final DocumentServiceApiProvider documentServiceApiProvider;
    private final UserServiceApiProvider userServiceApiProvider;
    private final DocumentMapper documentMapper;
    private final TaskDetailsProvider taskDetailsProvider;
    private final UserProvider userProvider;

    public DocumentService(RuntimeService runtimeService, TaskService taskService, ProcessTaskUtils processTaskUtils, DocumentServiceApiProvider documentServiceApiProvider, UserServiceApiProvider userServiceApiProvider, DocumentMapper documentMapper, TaskDetailsProvider taskDetailsProvider, UserProvider userProvider) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.processTaskUtils = processTaskUtils;
        this.documentServiceApiProvider = documentServiceApiProvider;
        this.userServiceApiProvider = userServiceApiProvider;
        this.documentMapper = documentMapper;
        this.taskDetailsProvider = taskDetailsProvider;
        this.userProvider = userProvider;
    }

    public void inspectDocument(InspectDocumentRequest inspectDocumentRequest) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(IS_DOCUMENT_VALID, inspectDocumentRequest.getIsValid());
        if (inspectDocumentRequest.getIsValid()) {
            variables.put(APPROVERS, inspectDocumentRequest.getApprovers());
            variables.put(DELEGATOR_ID, inspectDocumentRequest.getDelegatorId());
        }
        taskService.complete(inspectDocumentRequest.getTaskId(), variables);
    }

    public void uploadDocument(UploadDocumentRequest uploadDocumentRequest) {
        try {
            String uploadedDocumentId = documentServiceApiProvider.uploadDocument(userProvider.getCurrentUserId(), uploadDocumentRequest.getDescription(), uploadDocumentRequest.getDocument());
            runtimeService.startProcessInstanceByKey(SIGNING_PROCESS, uploadedDocumentId, Collections.singletonMap(DOCUMENT_ID, uploadedDocumentId));
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DocumentResponse> getDocumentsForInspection() {
        List<TaskDocumentModel> taskToDocumentIdMapForFormKey = processTaskUtils.getTaskDocumentModelListForFormKey(ProcessFormKey.INSPECT_DOCUMENT);
        try {
            return taskDetailsProvider.appendDocumentsInformationToTask(taskToDocumentIdMapForFormKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DocumentResponse> getDocumentsForApproval() {
        List<TaskDocumentModel> taskToDocumentIdMapForFormKey = processTaskUtils.getTaskDocumentModelListForFormKeyAndAuthenticatedUser(ProcessFormKey.APPROVE_DOCUMENT);
        try {
            return taskDetailsProvider.appendDocumentsInformationToTask(taskToDocumentIdMapForFormKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DocumentWithContent getDocumentDetails(String taskId) {
        String documentId = processTaskUtils.getDocumentId(taskId);
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

    private User getUploaderDetails(String uploaderId) throws Exception {
        return userServiceApiProvider.getUsersByIds(Collections.singletonList(uploaderId)).get(0);
    }
}
