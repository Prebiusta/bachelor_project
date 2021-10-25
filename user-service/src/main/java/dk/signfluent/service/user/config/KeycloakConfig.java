package dk.signfluent.service.user.config;

import dk.signfluent.integration.keycloak.config.KeycloakIntegrationConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {
    @Value("${keycloak.auth-server-url}")
    private String serverUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Value("${service-account.username}")
    private String idmUsername;

    @Value("${service-account.password}")
    private String idmPassword;

    @Bean
    public KeycloakIntegrationConfiguration keycloakConfiguration() {
        return new KeycloakIntegrationConfiguration() {
            @Override
            public String getServerUrl() {
                return serverUrl;
            }

            @Override
            public String getRealm() {
                return realm;
            }

            @Override
            public String getClientId() {
                return clientId;
            }

            @Override
            public String getClientSecret() {
                return clientSecret;
            }

            @Override
            public String getIDMUsername() {
                return idmUsername;
            }

            @Override
            public String getIDMPassword() {
                return idmPassword;
            }
        };
    }
}
