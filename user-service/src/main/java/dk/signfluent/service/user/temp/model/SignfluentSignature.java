package dk.signfluent.service.user.temp.model;

import lombok.Data;

@Data
public class SignfluentSignature {
    private String signedHash;
    private String certificate;
    private String taskId;
}
