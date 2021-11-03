package dk.signfluent.integration.keycloak.config;

import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@org.springframework.context.annotation.Configuration
public class KeycloakAuthzConfig {
    private final KeycloakIntegrationConfiguration keycloakIntegrationConfiguration;

    public KeycloakAuthzConfig(KeycloakIntegrationConfiguration keycloakIntegrationConfiguration) {
        this.keycloakIntegrationConfiguration = keycloakIntegrationConfiguration;
    }

    @Bean
    public AuthzClient authzClient() {
        Configuration configuration = new Configuration(
                keycloakIntegrationConfiguration.getServerUrl(), keycloakIntegrationConfiguration.getRealm(),
                keycloakIntegrationConfiguration.getClientId(), Collections.singletonMap("secret", keycloakIntegrationConfiguration.getClientSecret()), null);
        return AuthzClient.create(configuration);
    }
}
