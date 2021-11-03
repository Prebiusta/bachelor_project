package dk.signfluent.integration.keycloak.model;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String refreshToken;
}
