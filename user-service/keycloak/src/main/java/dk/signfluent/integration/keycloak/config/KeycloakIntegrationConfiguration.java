package dk.signfluent.integration.keycloak.config;

public interface KeycloakIntegrationConfiguration {
    String getServerUrl();

    String getRealm();

    String getClientId();

    String getClientSecret();

    String getIDMUsername();

    String getIDMPassword();
}
