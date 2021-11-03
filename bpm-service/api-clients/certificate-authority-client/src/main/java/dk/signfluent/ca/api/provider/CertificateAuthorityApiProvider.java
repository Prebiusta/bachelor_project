package dk.signfluent.ca.api.provider;

import dk.signfluent.ca.invoker.ApiException;
import dk.signfluent.ca.model.IssueX509CertificateRequest;
import dk.signfluent.ca.model.SignatureValidationRequest;

public interface CertificateAuthorityApiProvider {
    Boolean validateSignature(SignatureValidationRequest signatureValidationRequest) throws ApiException;

    String issueX509Certificate(IssueX509CertificateRequest issueX509CertificateRequest) throws ApiException;
}
