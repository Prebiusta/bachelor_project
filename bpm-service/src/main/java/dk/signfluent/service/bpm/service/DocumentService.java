package dk.signfluent.service.bpm.service;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.InspectDocumentRequest;
import dk.signfluent.service.bpm.model.UploadDocumentRequest;
import dk.signfluent.service.bpm.utility.ProcessFormKey;
import dk.signfluent.service.bpm.utility.ProcessTaskUtils;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dk.signfluent.service.bpm.utility.ProcessVariables.*;
import static dk.signfluent.service.bpm.utility.Processes.SIGNING_PROCESS;


@Service
public class DocumentService {
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final ProcessTaskUtils processTaskUtils;
    private final DocumentServiceApiProvider documentServiceApiProvider;

    public DocumentService(RuntimeService runtimeService, TaskService taskService, ProcessTaskUtils processTaskUtils, DocumentServiceApiProvider documentServiceApiProvider) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.processTaskUtils = processTaskUtils;
        this.documentServiceApiProvider = documentServiceApiProvider;
    }

    public void inspectDocument(InspectDocumentRequest inspectDocumentRequest) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(IS_DOCUMENT_VALID, inspectDocumentRequest.getIsValid());
        variables.put(APPROVERS, inspectDocumentRequest.getApprovers());
        taskService.complete(inspectDocumentRequest.getTaskId(), variables);
    }

    public void uploadDocument(UploadDocumentRequest uploadDocumentRequest) {
        try {
            String uploadedDocumentId = documentServiceApiProvider.uploadDocument(uploadDocumentRequest.getUserId(), uploadDocumentRequest.getDescription(), uploadDocumentRequest.getDocument());
            runtimeService.startProcessInstanceByKey(SIGNING_PROCESS, uploadedDocumentId, Collections.singletonMap(DOCUMENT_ID, uploadedDocumentId));
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DocumentRow> getDocumentsForInspection() {
        List<String> availableInspectionDocumentIds = processTaskUtils.getDocumentIdsForFormKey(ProcessFormKey.ASSIGN_APPROVERS);
        try {
            return documentServiceApiProvider.getDocumentList(availableInspectionDocumentIds);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Document getDocumentDetails(String taskId) {
        String documentId = processTaskUtils.getDocumentId(taskId);
        // resolve documentId for taskId
        // call document service with documentId to retrieve data
        return null;
    }
}
