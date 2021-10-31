package dk.signfluent.service.bpm.controller.api;

import dk.signfluent.ca.api.provider.CertificateAuthorityApiProvider;
import dk.signfluent.ca.invoker.ApiException;
import dk.signfluent.ca.model.IssueX509CertificateRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dk.signfluent.service.bpm.utility.AuthorizationTypes.APPROVER;

@RestController
@RequestMapping("/api/certificateAuthority")
public class CertificateAuthorityController {
    private final CertificateAuthorityApiProvider certificateAuthorityApiProvider;

    public CertificateAuthorityController(CertificateAuthorityApiProvider certificateAuthorityApiProvider) {
        this.certificateAuthorityApiProvider = certificateAuthorityApiProvider;
    }

    @PostMapping("/issueX509Certificate")
    @ApiOperation(value = "Issues X509 Certificate and returns in PEM format", nickname = "issueX509Certificate")
    @PreAuthorize(APPROVER)
    public String issueX509Certificate(@RequestBody IssueX509CertificateRequest issueX509CertificateRequest) throws ApiException {
        return certificateAuthorityApiProvider.issueX509Certificate(issueX509CertificateRequest);
    }
}
