package dk.signfluent.service.bpm.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloakAuthServerURLProvider {
    @Value("${idp-keycloak.service.host}")
    private String host;

    @Value("${idp-keycloak.service.port}")
    private String port;

    public String getKeycloakAuthServerURL() {
        return String.format("http://%s:%s/auth", host, port);
    }
}
