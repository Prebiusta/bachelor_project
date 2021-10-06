package dk.signfluent.certificateauthority.validation.services;

import dk.signfluent.certificateauthority.validation.model.SignatureValidation;
import org.springframework.stereotype.Service;

import java.security.Signature;
import java.security.cert.X509Certificate;

@Service
public class ValidationService {

    private final SignatureService signatureService;

    public ValidationService(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    public boolean validateSignature(SignatureValidation validation) {
        try {
            X509Certificate certificate = validation.getSignature().getX509Certificate();
            byte[] signedHash = validation.getSignature().getSignedHash();
            byte[] hash = validation.getHash();

            Signature signatureProcess = this.signatureService.instantiateProcess();
            signatureProcess.initVerify(certificate.getPublicKey());
            signatureProcess.update(hash);

            return signatureProcess.verify(signedHash);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
