package dk.signfluent.certificateauthority.certificatemanagement.network;

import lombok.Data;

@Data
public class IssueX509CertificateRequest {
    private String userId;
    private String publicKeyPem;
}