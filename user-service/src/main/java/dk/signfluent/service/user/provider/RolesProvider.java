package dk.signfluent.service.user.provider;

import dk.signfluent.integration.keycloak.model.UserRequest;
import dk.signfluent.integration.keycloak.service.KeycloakUserManagementService;
import dk.signfluent.integration.keycloak.util.SignfluentRole;
import dk.signfluent.service.user.model.SignfluentRoleResponse;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RolesProvider {
    private final KeycloakUserManagementService keycloakUserManagementService;

    public RolesProvider(KeycloakUserManagementService keycloakUserManagementService) {
        this.keycloakUserManagementService = keycloakUserManagementService;
    }

    public List<SignfluentRoleResponse> getAvailableRoles() {
        return Arrays.stream(SignfluentRole.values())
                .map(this::mapSignfluentRoleToResponse)
                .collect(Collectors.toList());
    }

    public List<SignfluentRoleResponse> getRolesForUser(UserRequest userRequest) {
        return keycloakUserManagementService.getRolesForUser(userRequest)
                .stream()
                .map(RoleRepresentation::getName)
                .map(SignfluentRole::resolveRoleForKey)
                .filter(Objects::nonNull)
                .map(this::mapSignfluentRoleToResponse)
                .collect(Collectors.toList());
    }

    private SignfluentRoleResponse mapSignfluentRoleToResponse(SignfluentRole signfluentRole) {
        SignfluentRoleResponse response = new SignfluentRoleResponse();
        response.setKey(signfluentRole.getKey());
        response.setName(signfluentRole.getName());
        return response;
    }
}
