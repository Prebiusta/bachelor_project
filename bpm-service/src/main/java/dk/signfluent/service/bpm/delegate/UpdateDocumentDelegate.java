package dk.signfluent.service.bpm.delegate;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.SignDocument;
import dk.signfluent.document.service.model.Signature;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static dk.signfluent.service.bpm.utility.ProcessVariables.*;

@Component
@Slf4j
public class UpdateDocumentDelegate implements JavaDelegate {
    private final DocumentServiceApiProvider documentServiceApiProvider;

    public UpdateDocumentDelegate(DocumentServiceApiProvider documentServiceApiProvider) {
        this.documentServiceApiProvider = documentServiceApiProvider;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws ApiException {
        documentServiceApiProvider.signDocument(getSignDocument(delegateExecution));
    }

    public SignDocument getSignDocument(DelegateExecution delegateExecution) {
        SignDocument signDocument = new SignDocument();
        signDocument.setSignature(getSignature(delegateExecution));
        signDocument.setDocumentId(UUID.fromString((String) delegateExecution.getVariable(DOCUMENT_ID)));
        return signDocument;
    }

    public Signature getSignature(DelegateExecution delegateExecution) {
        Signature signature = new Signature();
        signature.setSignedContent((String) delegateExecution.getVariable(SIGNED_CONTENT));
        signature.setX509Pem((String) delegateExecution.getVariable(X509PEM));
        return signature;
    }
}