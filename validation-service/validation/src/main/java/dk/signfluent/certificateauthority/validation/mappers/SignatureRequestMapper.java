package dk.signfluent.certificateauthority.validation.mappers;

import dk.signfluent.certificateauthority.util.Base64Mapper;
import dk.signfluent.certificateauthority.validation.dto.SignfluentSignatureDTO;
import dk.signfluent.certificateauthority.validation.model.SignatureValidation;
import dk.signfluent.certificateauthority.validation.model.SignfluentSignature;
import dk.signfluent.certificateauthority.validation.network.SignatureValidationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class SignatureRequestMapper extends Base64Mapper {

    @Mappings({
            @Mapping(source = "base64X509Certificate", target = "x509Certificate", qualifiedByName = "base64ToX509"),
            @Mapping(source = "base64SignedHash", target = "signedHash", qualifiedByName = "base64ToBytes"),
    })
    public abstract SignfluentSignature mapSignatureDTO(SignfluentSignatureDTO signfluentSignatureDTO);

    @Mappings({
            @Mapping(source = "hash", target = "hash", qualifiedByName = "base64ToBytes"),
    })
    public abstract SignatureValidation mapSignatureRequest(SignatureValidationRequest signatureValidation);
}
