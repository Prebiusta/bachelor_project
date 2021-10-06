package dk.signfluent.certificateauthority.validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.cert.X509Certificate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignfluentSignature {
    private X509Certificate X509Certificate;
    private byte[] signedHash;
}
