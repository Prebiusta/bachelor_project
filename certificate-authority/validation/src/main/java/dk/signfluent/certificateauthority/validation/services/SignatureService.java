package dk.signfluent.certificateauthority.validation.services;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

@Service
public class SignatureService {
    public Signature instantiateProcess() throws NoSuchAlgorithmException {
        return Signature.getInstance("SHA256withRSA");
    }
}
