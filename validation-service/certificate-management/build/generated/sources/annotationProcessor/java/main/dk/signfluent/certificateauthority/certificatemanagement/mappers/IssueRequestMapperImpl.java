package dk.signfluent.certificateauthority.certificatemanagement.mappers;

import dk.signfluent.certificateauthority.certificatemanagement.model.UserDetails;
import dk.signfluent.certificateauthority.certificatemanagement.network.IssueX509CertificateRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-06T12:12:47+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class IssueRequestMapperImpl extends IssueRequestMapper {

    @Override
    public UserDetails mapRequestToUserDetails(IssueX509CertificateRequest issueX509CertificateRequest) {
        if ( issueX509CertificateRequest == null ) {
            return null;
        }

        UserDetails userDetails = new UserDetails();

        userDetails.setUserId( issueX509CertificateRequest.getUserId() );
        userDetails.setPublicKeyPem( parsePublicKeyPem( issueX509CertificateRequest.getPublicKeyPem() ) );

        return userDetails;
    }
}
