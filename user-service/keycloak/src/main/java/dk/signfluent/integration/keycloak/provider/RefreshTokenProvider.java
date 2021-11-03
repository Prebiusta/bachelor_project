package dk.signfluent.integration.keycloak.provider;

import dk.signfluent.integration.keycloak.config.KeycloakIntegrationConfiguration;
import dk.signfluent.integration.keycloak.model.RefreshTokenRequest;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.authorization.client.util.Http;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenProvider {
    private final KeycloakIntegrationConfiguration keycloakIntegrationConfiguration;
    private final Configuration keycloakConfig;

    public RefreshTokenProvider(KeycloakIntegrationConfiguration keycloakIntegrationConfiguration, Configuration keycloakConfig) {
        this.keycloakIntegrationConfiguration = keycloakIntegrationConfiguration;
        this.keycloakConfig = keycloakConfig;
    }

    public AccessTokenResponse refreshAuthToken(RefreshTokenRequest refreshTokenRequest) {
        String url = keycloakIntegrationConfiguration.getServerUrl() + "/realms/" + keycloakIntegrationConfiguration.getRealm() + "/protocol/openid-connect/token";
        Http http = new Http(keycloakConfig, (params, headers) -> {});

        return http.<AccessTokenResponse>post(url)
                .authentication()
                .client()
                .form()
                .param("grant_type", "refresh_token")
                .param("refresh_token", refreshTokenRequest.getRefreshToken())
                .param("client_id", keycloakIntegrationConfiguration.getClientId())
                .param("client_secret", keycloakIntegrationConfiguration.getClientSecret())
                .response()
                .json(AccessTokenResponse.class)
                .execute();
    }
}
