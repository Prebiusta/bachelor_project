package dk.signfluent.certificateauthority.certificatemanagement.controller;

import dk.signfluent.certificateauthority.certificatemanagement.network.IssueX509CertificateRequest;
import dk.signfluent.certificateauthority.certificatemanagement.services.CertificateService;
import dk.signfluent.certificateauthority.util.Base64Handler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.CertificateEncodingException;

@RestController
@RequestMapping("api/certificates")
public class CertificateController {

    private final CertificateService certificateService;
    private final Base64Handler base64Handler;

    public CertificateController(CertificateService certificateService, Base64Handler base64Handler) {
        this.certificateService = certificateService;
        this.base64Handler = base64Handler;
    }

    @PostMapping("/issue")
    public String issueX509Certificate(@RequestBody IssueX509CertificateRequest request) throws CertificateEncodingException {
        return base64Handler.encodeX509(certificateService.issueX509Certificate(request));
    }
}
