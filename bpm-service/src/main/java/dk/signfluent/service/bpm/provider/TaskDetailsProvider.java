package dk.signfluent.service.bpm.provider;

import dk.signfluent.service.bpm.model.response.DocumentResponse;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskDetailsProvider {
    public List<DocumentResponse> appendDocumentsInformationToTask(List<ProcessInstance> processInstanceList) throws Exception {
        return processInstanceList.stream().map(this::mapProcessInstanceToDocumentResponse).collect(Collectors.toList());
    }

    private DocumentResponse mapProcessInstanceToDocumentResponse(ProcessInstance processInstance) {
        DocumentResponse documentResponse = new DocumentResponse();
        documentResponse.setDocumentId(extractDocumentIdFromProcessInstance(processInstance));
        documentResponse.setProcessId(processInstance.getProcessInstanceId());
        return documentResponse;
    }

    private String extractDocumentIdFromProcessInstance(ProcessInstance processInstance) {
        return processInstance.getBusinessKey();
    }
}
