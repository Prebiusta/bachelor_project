package dk.signfluent.integration.keycloak.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdminConfig {
    private final KeycloakIntegrationConfiguration keycloakIntegrationConfiguration;

    public KeycloakAdminConfig(KeycloakIntegrationConfiguration keycloakIntegrationConfiguration) {
        this.keycloakIntegrationConfiguration = keycloakIntegrationConfiguration;
    }

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakIntegrationConfiguration.getServerUrl())
                .realm(keycloakIntegrationConfiguration.getRealm())
                .grantType(OAuth2Constants.PASSWORD)
                .clientId(keycloakIntegrationConfiguration.getClientId())
                .clientSecret(keycloakIntegrationConfiguration.getClientSecret())
                .username(keycloakIntegrationConfiguration.getIDMUsername())
                .password(keycloakIntegrationConfiguration.getIDMPassword())
                .build();
    }

    @Bean
    public RealmResource realmResource(Keycloak keycloak) {
        return keycloak.realm(keycloakIntegrationConfiguration.getRealm());
    }

    @Bean
    public UsersResource userResource(RealmResource realmResource) {
        return realmResource.users();
    }

    @Bean
    public ClientsResource clientsResource(RealmResource realmResource) {
        return realmResource.clients();
    }

    @Bean
    public RolesResource rolesResource(RealmResource realmResource) {
        return realmResource.roles();
    }
}
