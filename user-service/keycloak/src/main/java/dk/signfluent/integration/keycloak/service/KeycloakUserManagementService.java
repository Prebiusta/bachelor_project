package dk.signfluent.integration.keycloak.service;


import dk.signfluent.integration.keycloak.model.*;
import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

public interface KeycloakUserManagementService {
    UserCreateResponse createUser(UserCreateRequest userCreateRequest);

    List<User> getAllApprovers();

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    AuthenticationResponse refreshToken(RefreshTokenRequest request);

    void assignRole(RoleManagementRequest roleManagementRequest);

    void revokeRole(RoleManagementRequest roleManagementRequest);

    List<RoleRepresentation> getRolesForUser(UserRequest userRequest);
}
