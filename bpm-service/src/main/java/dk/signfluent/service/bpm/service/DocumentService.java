package dk.signfluent.service.bpm.service;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.bpm.mapper.DocumentMapper;
import dk.signfluent.service.bpm.model.*;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.bpm.utility.ProcessFormKey;
import dk.signfluent.service.bpm.utility.ProcessTaskUtils;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dk.signfluent.service.bpm.utility.ProcessVariables.*;
import static dk.signfluent.service.bpm.utility.Processes.SIGNING_PROCESS;


@Service
public class DocumentService {
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final ProcessTaskUtils processTaskUtils;
    private final DocumentServiceApiProvider documentServiceApiProvider;
    private final DocumentMapper documentMapper;

    public DocumentService(RuntimeService runtimeService, TaskService taskService, ProcessTaskUtils processTaskUtils, DocumentServiceApiProvider documentServiceApiProvider, DocumentMapper documentMapper) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.processTaskUtils = processTaskUtils;
        this.documentServiceApiProvider = documentServiceApiProvider;
        this.documentMapper = documentMapper;
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
            String uploadedDocumentId = documentServiceApiProvider.uploadDocument(uploadDocumentRequest.getUserId(), uploadDocumentRequest.getDescription(), uploadDocumentRequest.getDocument());
            runtimeService.startProcessInstanceByKey(SIGNING_PROCESS, uploadedDocumentId, Collections.singletonMap(DOCUMENT_ID, uploadedDocumentId));
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DocumentResponse> getDocumentsForInspection() {
        List<TaskDocumentModel> taskToDocumentIdMapForFormKey = processTaskUtils.getTaskToDocumentIdMapForFormKey(ProcessFormKey.ASSIGN_APPROVERS);
        try {
            List<DocumentRow> documentList = documentServiceApiProvider.getDocumentList(taskToDocumentIdMapForFormKey.stream().map(TaskDocumentModel::getDocumentId).collect(Collectors.toList()));
            return assignTaskToDocument(documentList, taskToDocumentIdMapForFormKey);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public DocumentWithContent getDocumentDetails(String taskId) {
        String documentId = processTaskUtils.getDocumentId(taskId);
        try {
            DocumentContent documentDetails = documentServiceApiProvider.getDocumentDetails(documentId);
            return documentMapper.mapDocumentWithContent(documentDetails);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    private List<DocumentResponse> assignTaskToDocument(List<DocumentRow> documentList, List<TaskDocumentModel> taskIdsForDocuments) {
        return taskIdsForDocuments.stream()
                .map(taskDocumentModel -> {
                    DocumentResponse documentResponse = new DocumentResponse();
                    documentResponse.setTaskId(taskDocumentModel.getTaskId());
                    documentResponse.setDocument(findDocumentRow(documentList, taskDocumentModel.getDocumentId()));
                    return documentResponse;
                })
                .collect(Collectors.toList());
    }

    private Document findDocumentRow(List<DocumentRow> documentRows, String documentId) {
        DocumentRow documentRow = documentRows.stream()
                .filter(doc -> {
                    assert doc.getDocumentId() != null;
                    return doc.getDocumentId().toString().equalsIgnoreCase(documentId);
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("DocumentID not Found"));
        return documentMapper.mapDocumentRowToDocument(documentRow);
    }
}
