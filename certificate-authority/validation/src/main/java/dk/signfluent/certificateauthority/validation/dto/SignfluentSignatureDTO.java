package dk.signfluent.certificateauthority.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignfluentSignatureDTO {
    private String x509Certificate;
    private String signedContent;
}
