package dk.signfluent.integration.keycloak.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
