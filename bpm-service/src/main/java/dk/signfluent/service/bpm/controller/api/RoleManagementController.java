package dk.signfluent.service.bpm.controller.api;

import dk.signfluent.service.bpm.provider.UserProvider;
import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.BaseResponse;
import dk.signfluent.user.service.model.RoleManagementRequest;
import dk.signfluent.user.service.model.SignfluentRoleResponse;
import dk.signfluent.user.service.model.UserRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;

import static dk.signfluent.service.bpm.utility.AuthorizationTypes.ADMINISTRATOR;

@RestController
@RequestMapping("/api/role")
public class RoleManagementController {
    private final UserServiceApiProvider userServiceApiProvider;
    private final UserProvider userProvider;

    public RoleManagementController(UserServiceApiProvider userServiceApiProvider, UserProvider userProvider) {
        this.userServiceApiProvider = userServiceApiProvider;
        this.userProvider = userProvider;
    }

    @PostMapping("/assign")
    @ApiOperation(value = "Assign a role to the user", nickname = "assign")
    @PreAuthorize(ADMINISTRATOR)
    public BaseResponse assignRole(@RequestBody RoleManagementRequest roleManagementRequest) throws ApiException {
        return userServiceApiProvider.assignRole(roleManagementRequest);
    }

    @PostMapping("/revoke")
    @ApiOperation(value = "Revoke a role from the user", nickname = "revoke")
    @PreAuthorize(ADMINISTRATOR)
    public BaseResponse revokeRole(@RequestBody RoleManagementRequest roleManagementRequest) throws ApiException {
        return userServiceApiProvider.revokeRole(roleManagementRequest);
    }

    @PostMapping("/getAll")
    @ApiOperation(value = "Returns all available roles", nickname = "getAll")
    @PreAuthorize(ADMINISTRATOR)
    public List<SignfluentRoleResponse> getAllRoles() throws ApiException {
        return userServiceApiProvider.getAvailableRoles();
    }

    @PostMapping("/getForUser")
    @ApiOperation(value = "Returns roles for specified user", nickname = "getAlForUser")
    @PreAuthorize("hasAuthority('administrator')")
    public List<SignfluentRoleResponse> getForUser(@RequestBody UserRequest userRequest) throws ApiException {
        return userServiceApiProvider.getRoleForUser(userRequest);
    }

    @PostMapping("/getForCurrentUser")
    @ApiOperation(value = "Returns all roles for currently authenticated user", nickname = "getAllForCurrentUser")
    public List<SignfluentRoleResponse> getForCurrentUser() throws ApiException {
        return userServiceApiProvider.getRoleForUser(new UserRequest().userId(userProvider.getCurrentUserId()));
    }
}
