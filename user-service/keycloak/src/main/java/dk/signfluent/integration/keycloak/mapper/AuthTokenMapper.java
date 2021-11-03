package dk.signfluent.integration.keycloak.mapper;

import dk.signfluent.integration.keycloak.model.AuthenticationResponse;
import org.keycloak.TokenVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AuthTokenMapper {
    @Named("extractUserIdFromToken")
    default String extractUserIdFromToken(String tokenString) throws VerificationException {
        AccessToken token = TokenVerifier.create(tokenString, AccessToken.class).getToken();
        return token.getSubject();
    }


    @Mapping(source = "token", target = "userId", qualifiedByName = "extractUserIdFromToken")
    AuthenticationResponse mapAccessTokenToAuthResponse(AccessTokenResponse accessTokenResponse);
}
