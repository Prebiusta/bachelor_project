package dk.signfluent.integration.keycloak.model;

import lombok.Data;

@Data
public class UserCreateResponse {
    private String userId;

    public UserCreateResponse(String userId) {
        this.userId = userId;
    }
}
