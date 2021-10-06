package dk.signfluent.certificateauthority.validation.mappers;

import dk.signfluent.certificateauthority.validation.dto.SignfluentSignatureDTO;
import dk.signfluent.certificateauthority.validation.model.SignatureValidation;
import dk.signfluent.certificateauthority.validation.model.SignfluentSignature;
import dk.signfluent.certificateauthority.validation.network.SignatureValidationRequest;
import java.security.cert.CertificateException;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-06T11:57:44+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class SignatureRequestMapperImpl extends SignatureRequestMapper {

    @Override
    public SignfluentSignature mapSignatureDTO(SignfluentSignatureDTO signfluentSignatureDTO) {
        if ( signfluentSignatureDTO == null ) {
            return null;
        }

        SignfluentSignature signfluentSignature = new SignfluentSignature();

        try {
            signfluentSignature.setX509Certificate( base64ToX509( signfluentSignatureDTO.getBase64X509Certificate() ) );
        }
        catch ( CertificateException e ) {
            throw new RuntimeException( e );
        }
        signfluentSignature.setSignedHash( base64ToBytes( signfluentSignatureDTO.getBase64SignedHash() ) );

        return signfluentSignature;
    }

    @Override
    public SignatureValidation mapSignatureRequest(SignatureValidationRequest signatureValidation) {
        if ( signatureValidation == null ) {
            return null;
        }

        SignatureValidation signatureValidation1 = new SignatureValidation();

        signatureValidation1.setHash( base64ToBytes( signatureValidation.getHash() ) );
        signatureValidation1.setSignature( mapSignatureDTO( signatureValidation.getSignature() ) );

        return signatureValidation1;
    }
}
