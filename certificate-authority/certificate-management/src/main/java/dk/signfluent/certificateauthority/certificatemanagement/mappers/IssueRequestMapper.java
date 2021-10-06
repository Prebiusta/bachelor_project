package dk.signfluent.certificateauthority.certificatemanagement.mappers;

import dk.signfluent.certificateauthority.certificatemanagement.model.UserDetails;
import dk.signfluent.certificateauthority.certificatemanagement.network.IssueX509CertificateRequest;
import dk.signfluent.certificateauthority.util.Base64Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class IssueRequestMapper extends Base64Mapper
{
    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "publicKeyPem", target = "publicKeyPem", qualifiedByName = "parsePublicKeyPem"),
    })
    public abstract UserDetails mapRequestToUserDetails(IssueX509CertificateRequest issueX509CertificateRequest);

    @Named("parsePublicKeyPem")
    public byte[] parsePublicKeyPem(String publicKeyPem) {
        return this.base64ToBytes(publicKeyPem.replaceAll("\\n", "")
                .replaceAll("\\r", "")
                .replace("-----BEGIN RSA PUBLIC KEY-----", "")
                .replace("-----END RSA PUBLIC KEY-----", ""));
    }

}
