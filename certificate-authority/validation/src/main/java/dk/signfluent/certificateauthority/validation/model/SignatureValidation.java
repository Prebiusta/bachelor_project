package dk.signfluent.certificateauthority.validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignatureValidation {
    public SignfluentSignature signature;
    public byte[] content;
}
