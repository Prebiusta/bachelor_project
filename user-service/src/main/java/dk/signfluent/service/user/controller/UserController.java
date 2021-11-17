package dk.signfluent.service.user.controller;

import dk.signfluent.integration.keycloak.model.*;
import dk.signfluent.integration.keycloak.service.KeycloakUserManagementService;
import dk.signfluent.service.user.model.SignfluentRoleResponse;
import dk.signfluent.service.user.model.response.BaseResponse;
import dk.signfluent.service.user.provider.RolesProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
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

    @PostMapping("/create")
    @ApiOperation(value = "Creates a user", nickname = "createUser")
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest, ServletRequest servletRequest) {
        return keycloakUserManagementService.createUser(userCreateRequest);
    }

    @PostMapping("/assignRole")
    @ApiOperation(value = "Assigns a role to the user", nickname = "assignRole")
    public BaseResponse assignRole(@RequestBody RoleManagementRequest roleManagementRequest) {
        keycloakUserManagementService.assignRole(roleManagementRequest);
        return BaseResponse.createSuccessful();
    }

    @PostMapping("/revokeRole")
    @ApiOperation(value = "Removes a role from the user", nickname = "revokeRole")
    public BaseResponse revokeRole(@RequestBody RoleManagementRequest roleManagementRequest) {
        keycloakUserManagementService.revokeRole(roleManagementRequest);
        return BaseResponse.createSuccessful();
    }

    @PostMapping("/getAvailableRoles")
    @ApiOperation(value = "Returns available roles to be assigned", nickname = "getAvailableRoles")
    public List<SignfluentRoleResponse> getAvailableRoles() {
        return rolesProvider.getAvailableRoles();
    }

    @PostMapping("/getRolesForUser")
    @ApiOperation(value = "Returns roles for specified user", nickname = "getRolesForUser")
    public List<SignfluentRoleResponse> getRolesForUser(@RequestBody UserRequest userRequest) {
        return rolesProvider.getRolesForUser(userRequest);
    }

    @PostMapping("/getAvailableApprovers")
    @ApiOperation(value = "Get Available Approvers", nickname = "getAvailableApprovers")
    public List<User> getAvailableApprovers() {
        return keycloakUserManagementService.getAllApprovers();
    }

    @PostMapping("/getUsersByIds")
    @ApiOperation(value = "Get users by ids", nickname = "getUsersByIds")
    public List<User> getUsersByIds(@RequestBody List<String> userIds) {
        return keycloakUserManagementService.getUsers(userIds);
    }

    @PostMapping("/getAll")
    @ApiOperation(value = "Get all users", nickname = "getAllUsers")
    public List<User> getAllUsers() {
        return keycloakUserManagementService.getAllUsers();
    }
}
