package dk.signfluent.integration.keycloak.model;

import lombok.Data;

@Data
public class RoleManagementRequest {
    private String userId;
    private String role;
}
