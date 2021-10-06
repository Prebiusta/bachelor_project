package dk.signfluent.certificateauthority.validation.network;

import dk.signfluent.certificateauthority.validation.dto.SignfluentSignatureDTO;
import lombok.Data;

@Data
public class SignatureValidationRequest {
    private SignfluentSignatureDTO signature;
    private String hash;
}
