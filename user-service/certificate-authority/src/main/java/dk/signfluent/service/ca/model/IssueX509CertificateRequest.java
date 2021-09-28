package dk.signfluent.service.ca.model;

import lombok.Data;

@Data
public class IssueX509CertificateRequest {
    private String userId;
    private String publicKeyPem;
}
