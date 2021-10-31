package dk.signfluent.certificateauthority.certificatemanagement.controller;

import dk.signfluent.certificateauthority.certificatemanagement.mappers.IssueRequestMapper;
import dk.signfluent.certificateauthority.certificatemanagement.model.UserDetails;
import dk.signfluent.certificateauthority.certificatemanagement.network.IssueX509CertificateRequest;
import dk.signfluent.certificateauthority.certificatemanagement.services.CertificateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.CertificateEncodingException;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService certificateService;
    private final IssueRequestMapper mapper;

    public CertificateController(CertificateService certificateService, IssueRequestMapper mapper) {
        this.certificateService = certificateService;
        this.mapper = mapper;
    }

    @PostMapping("/issue")
    @ApiOperation(value = "Returns X.509 Certificate in PEM format", nickname = "issueX509Certificate")
    public String issueX509Certificate(@RequestBody IssueX509CertificateRequest request) throws CertificateEncodingException {
        UserDetails userDetails = mapper.mapRequestToUserDetails(request);
        return mapper.X509ToBase64(certificateService.issueX509Certificate(userDetails));
    }
}
