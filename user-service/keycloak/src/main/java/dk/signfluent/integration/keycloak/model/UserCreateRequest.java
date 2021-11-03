package dk.signfluent.integration.keycloak.model;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String email;
    private String lastName;
    private String firstName;
    private String password;
}
