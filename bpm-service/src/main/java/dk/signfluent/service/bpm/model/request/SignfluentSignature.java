package dk.signfluent.service.bpm.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SignfluentSignature extends TaskIdRequest {
    private String signedContent;
    private String x509Pem;
}
