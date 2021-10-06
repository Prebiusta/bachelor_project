package dk.signfluent.certificateauthority.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignfluentSignatureDTO {
    private String base64X509Certificate;
    private String base64SignedHash;
}
