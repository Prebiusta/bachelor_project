package dk.signfluent.service.bpm.delegate;

import dk.signfluent.ca.api.provider.CertificateAuthorityApiProvider;
import dk.signfluent.ca.model.SignatureValidationRequest;
import dk.signfluent.ca.model.SignfluentSignatureDTO;
import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.service.bpm.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static dk.signfluent.service.bpm.utility.ProcessVariables.*;

@Component
@Slf4j
public class VerifySignatureDelegate implements JavaDelegate {
    private final CertificateAuthorityApiProvider certificateAuthorityApiProvider;
    private final DocumentService documentService;

    public VerifySignatureDelegate(CertificateAuthorityApiProvider certificateAuthorityApiProvider, DocumentService documentService) {
        this.certificateAuthorityApiProvider = certificateAuthorityApiProvider;
        this.documentService = documentService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Boolean isValid = certificateAuthorityApiProvider.validateSignature(getSignatureValidationRequest(delegateExecution));
        if(!isValid) throw new BpmnError("-1");
    }

    private SignatureValidationRequest getSignatureValidationRequest(DelegateExecution delegateExecution) throws ApiException {
        String documentHash = documentService.getDocumentHash((String) delegateExecution.getVariable(DOCUMENT_ID));
        SignatureValidationRequest signatureValidationRequest = new SignatureValidationRequest();
        signatureValidationRequest.setContent(documentHash);
        signatureValidationRequest.setSignature(getSignfluentSignatureDto(delegateExecution));
        return signatureValidationRequest;
    }

    private SignfluentSignatureDTO getSignfluentSignatureDto(DelegateExecution delegateExecution) {
        SignfluentSignatureDTO signfluentSignatureDTO = new SignfluentSignatureDTO();
        signfluentSignatureDTO.setSignedContent((String) delegateExecution.getVariable(SIGNED_CONTENT));
        signfluentSignatureDTO.setX509Certificate((String) delegateExecution.getVariable(X509PEM));
        return signfluentSignatureDTO;
    }
}
