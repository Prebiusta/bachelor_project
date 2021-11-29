package dk.signfluent.service.bpm.delegate;

import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static dk.signfluent.service.bpm.utility.ProcessVariables.DOCUMENT_ID;

@Component
@Slf4j
public class LockDocumentDelegate implements JavaDelegate {
    private final DocumentServiceApiProvider documentServiceApiProvider;

    public LockDocumentDelegate(DocumentServiceApiProvider documentServiceApiProvider) {
        this.documentServiceApiProvider = documentServiceApiProvider;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        documentServiceApiProvider.lockDocument((String) delegateExecution.getVariable(DOCUMENT_ID));

    }
}
