package dk.signfluent.integration.keycloak.service;


import dk.signfluent.integration.keycloak.model.*;

import java.util.List;

public interface KeycloakUserManagementService {
    UserCreateResponse createUser(UserCreateRequest userCreateRequest);

    List<User> getAllApprovers();

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    void assignRole(RoleManagementRequest roleManagementRequest);

    void revokeRole(RoleManagementRequest roleManagementRequest);
}
