package dk.signfluent.service.user.api.provider.impl;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.api.AuthControllerApi;
import dk.signfluent.user.service.api.UserControllerApi;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceApiProviderImpl implements UserServiceApiProvider {
    private final UserControllerApi userControllerApi;
    private final AuthControllerApi authControllerApi;

    public UserServiceApiProviderImpl(UserControllerApi userControllerApi, AuthControllerApi authControllerApi) {
        this.userControllerApi = userControllerApi;
        this.authControllerApi = authControllerApi;
    }

    @Override
    public List<User> getAvailableApprovers() throws ApiException {
        return userControllerApi.getAvailableApprovers();
    }

    @Override
    public BaseResponse assignRole(RoleManagementRequest roleManagementRequest) throws ApiException {
        return userControllerApi.assignRole(roleManagementRequest);
    }

    @Override
    public BaseResponse revokeRole(RoleManagementRequest roleManagementRequest) throws ApiException {
        return userControllerApi.revokeRole(roleManagementRequest);
    }

    @Override
    public List<SignfluentRoleResponse> getAvailableRoles() throws ApiException {
        return userControllerApi.getAvailableRoles();
    }

    @Override
    public List<SignfluentRoleResponse> getForUser(UserRequest userRequest) throws ApiException {
        return userControllerApi.getRolesForUser(userRequest);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws ApiException {
        return authControllerApi.authenticate(authenticationRequest);
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) throws ApiException {
        return authControllerApi.refreshToken(refreshTokenRequest);
    }

    @Override
    public UserCreateResponse createUserAccount(UserCreateRequest userCreateRequest) throws ApiException {
        return userControllerApi.createUser(userCreateRequest);
    }
}
