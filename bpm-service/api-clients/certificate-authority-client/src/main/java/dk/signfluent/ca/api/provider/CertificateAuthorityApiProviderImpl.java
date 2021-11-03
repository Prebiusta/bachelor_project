package dk.signfluent.ca.api.provider;

import dk.signfluent.ca.api.CertificateControllerApi;
import dk.signfluent.ca.api.ValidationControllerApi;
import dk.signfluent.ca.invoker.ApiException;
import dk.signfluent.ca.model.IssueX509CertificateRequest;
import dk.signfluent.ca.model.SignatureValidationRequest;
import org.springframework.stereotype.Service;

@Service
public class CertificateAuthorityApiProviderImpl implements CertificateAuthorityApiProvider {
    private final ValidationControllerApi validationControllerApi;
    private final CertificateControllerApi certificateControllerApi;

    public CertificateAuthorityApiProviderImpl(ValidationControllerApi validationControllerApi, CertificateControllerApi certificateControllerApi) {
        this.validationControllerApi = validationControllerApi;
        this.certificateControllerApi = certificateControllerApi;
    }

    @Override
    public Boolean validateSignature(SignatureValidationRequest signatureValidationRequest) throws ApiException {
        return validationControllerApi.validateSignature(signatureValidationRequest);
    }

    @Override
    public String issueX509Certificate(IssueX509CertificateRequest issueX509CertificateRequest) throws ApiException {
        return certificateControllerApi.issueX509Certificate(issueX509CertificateRequest);
    }
}
