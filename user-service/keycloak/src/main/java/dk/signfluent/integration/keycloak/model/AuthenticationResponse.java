package dk.signfluent.integration.keycloak.model;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String userId;
    private String token;
    private long expiresIn;
    private long refreshExpiresIn;
    private String refreshToken;
    private String tokenType;
    private String idToken;
    private int notBeforePolicy;
}
