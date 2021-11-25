package dk.signfluent.service.bpm.delegate;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static dk.signfluent.service.bpm.utility.ProcessVariables.APPROVER;
import static dk.signfluent.service.bpm.utility.ProcessVariables.DOCUMENT_ID;

@Component
@Slf4j
public class UpdateRejectedDocumentDelegate implements JavaDelegate {
    private final DocumentServiceApiProvider documentServiceApiProvider;

    public UpdateRejectedDocumentDelegate(DocumentServiceApiProvider documentServiceApiProvider) {
        this.documentServiceApiProvider = documentServiceApiProvider;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws ApiException {
        documentServiceApiProvider.rejectDocument( (String)delegateExecution.getVariable(DOCUMENT_ID), (String)delegateExecution.getVariable(APPROVER));
        throw new BpmnError("-2");
    }
}
