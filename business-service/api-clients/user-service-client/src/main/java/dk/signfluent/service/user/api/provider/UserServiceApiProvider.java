package dk.signfluent.service.user.api.provider;

import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.*;

import java.util.List;

public interface UserServiceApiProvider {
    List<User> getAvailableApprovers() throws ApiException;

    List<User> getUsersByIds(List<String> ids) throws ApiException;

    List<User> getAllUsers() throws ApiException;

    BaseResponse assignRole(RoleManagementRequest roleManagementRequest) throws ApiException;

    BaseResponse revokeRole(RoleManagementRequest roleManagementRequest) throws ApiException;

    List<SignfluentRoleResponse> getAvailableRoles() throws ApiException;

    List<SignfluentRoleResponse> getRoleForUser(UserRequest userRequest) throws ApiException;

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws ApiException;

    AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) throws ApiException;

    UserCreateResponse createUserAccount(UserCreateRequest userCreateRequest) throws ApiException;
}
