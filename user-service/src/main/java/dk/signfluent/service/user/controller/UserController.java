package dk.signfluent.service.user.controller;

import dk.signfluent.integration.keycloak.model.*;
import dk.signfluent.integration.keycloak.service.KeycloakUserManagementService;
import dk.signfluent.service.user.model.AvailableRoleResponse;
import dk.signfluent.service.user.model.response.BaseResponse;
import dk.signfluent.service.user.provider.RolesProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final KeycloakUserManagementService keycloakUserManagementService;
    private final RolesProvider rolesProvider;

    public UserController(KeycloakUserManagementService keycloakUserManagementService, RolesProvider rolesProvider) {
        this.keycloakUserManagementService = keycloakUserManagementService;
        this.rolesProvider = rolesProvider;
    }

    @PostMapping("/getAvailableApprovers")
    @ApiOperation(value = "Get Available Approvers", nickname = "getAvailableApprovers")
    public List<User> getAvailableApprovers() {
        return keycloakUserManagementService.getAllApprovers();
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a user", nickname = "createUser")
    @PreAuthorize("hasAuthority('administrator')")
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return keycloakUserManagementService.createUser(userCreateRequest);
    }

    @PostMapping("/assignRole")
    @ApiOperation(value = "Assigns a role to the user", nickname = "assignRole")
    @PreAuthorize("hasAuthority('administrator')")
    public BaseResponse assignRole(@RequestBody RoleManagementRequest roleManagementRequest) {
        keycloakUserManagementService.assignRole(roleManagementRequest);
        return BaseResponse.createSuccessful();
    }

    @PostMapping("/revokeRole")
    @ApiOperation(value = "Removes a role from the user", nickname = "revokeRole")
    @PreAuthorize("hasAuthority('administrator')")
    public BaseResponse revokeRole(@RequestBody RoleManagementRequest roleManagementRequest) {
        keycloakUserManagementService.revokeRole(roleManagementRequest);
        return BaseResponse.createSuccessful();
    }

    @PostMapping("/getAvailableRoles")
    @ApiOperation(value = "Returns available roles to be assigned", nickname = "getAvailableRoles")
    @PreAuthorize("hasAuthority('administrator')")
    public List<AvailableRoleResponse> getAvailableRoles() {
        return rolesProvider.getAvailableRoles();
    }
}
