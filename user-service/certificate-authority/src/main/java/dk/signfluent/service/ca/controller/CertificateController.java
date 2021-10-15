package dk.signfluent.service.ca.controller;

import dk.signfluent.service.ca.model.IssueX509CertificateRequest;
import dk.signfluent.service.ca.provider.CertificateProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/api/certificateManagement")
public class CertificateController {
    private final CertificateProvider certificateProvider;

    public CertificateController(CertificateProvider certificateProvider) {
        this.certificateProvider = certificateProvider;
    }

    @PostMapping("/issue")
    public String generateX509Certificate(@RequestBody IssueX509CertificateRequest issueX509CertificateRequest) throws Exception {
        return Base64.getEncoder().encodeToString(certificateProvider.issueX509Certificate(issueX509CertificateRequest).getEncoded());
    }
}
