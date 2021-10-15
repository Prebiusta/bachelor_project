package dk.signfluent.service.bpm.service;

import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.InspectDocumentRequest;
import dk.signfluent.service.bpm.model.UploadDocumentRequest;
import dk.signfluent.service.bpm.utility.ProcessTaskUtils;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.stereotype.Service;

import java.util.*;

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
//        Map<String, Object> variables = Collections.singletonMap(IS_DOCUMENT_VALID, inspectDocumentRequest.getIsValid());
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(IS_DOCUMENT_VALID, inspectDocumentRequest.getIsValid());
        variables.put(APPROVERS, inspectDocumentRequest.getApprovers());
        taskService.complete(inspectDocumentRequest.getTaskId(), variables);
    }

    public void uploadDocument(UploadDocumentRequest uploadDocumentRequest) {
        String uploadedDocumentId = documentServiceApiProvider.uploadDocument(uploadDocumentRequest.getDocument(), uploadDocumentRequest.getUserId());
        runtimeService.startProcessInstanceByKey(SIGNING_PROCESS, uploadedDocumentId, getVariablesForUploadDocument(uploadedDocumentId));
    }

    //TODO:@David Return list of documents
    public List<Document> getDocumentsForInspection() {
        //Call document service endpoint and return it
        return Collections.emptyList();
    }

    private Map<String, Object> getVariablesForUploadDocument(String uploadedDocumentId) {
        //one value map
        return Collections.singletonMap(DOCUMENT_ID, uploadedDocumentId);
    }

    public Document getDocumentDetails(String taskId) {
        String documentId = processTaskUtils.getDocumentId(taskId);
        // resolve documentId for taskId
        // call document service with documentId to retrieve data
        return null;
    }
}
