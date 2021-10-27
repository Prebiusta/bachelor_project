package dk.signfluent.integration.keycloak.service;

import dk.signfluent.integration.keycloak.mapper.AuthTokenMapper;
import dk.signfluent.integration.keycloak.mapper.UserMapper;
import dk.signfluent.integration.keycloak.model.*;
import dk.signfluent.integration.keycloak.provider.RefreshTokenProvider;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeycloakUserManagementServiceImpl implements KeycloakUserManagementService {
    private final UsersResource usersResource;
    private final RolesResource rolesResource;
    private final RealmResource realmResource;
    private final UserMapper userMapper;
    private final AuthTokenMapper authTokenMapper;
    private final AuthzClient authzClient;
    private final RefreshTokenProvider refreshTokenProvider;

    public KeycloakUserManagementServiceImpl(UsersResource usersResource, RolesResource rolesResource, RealmResource realmResource, UserMapper userMapper, AuthTokenMapper authTokenMapper, AuthzClient authzClient, RefreshTokenProvider refreshTokenProvider) {
        this.usersResource = usersResource;
        this.rolesResource = rolesResource;
        this.realmResource = realmResource;
        this.userMapper = userMapper;
        this.authTokenMapper = authTokenMapper;
        this.authzClient = authzClient;
        this.refreshTokenProvider = refreshTokenProvider;
    }

    @Override
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
        Response response = usersResource.create(mapCreateRequestToUserRepresentation(userCreateRequest));
        String userId = CreatedResponseUtil.getCreatedId(response);
        setUserPassword(userCreateRequest.getPassword(), userId);
        return new UserCreateResponse(userId);
    }

    @Override
    public List<User> getAllApprovers() {
        ArrayList<UserRepresentation> userRepresentations = new ArrayList<>(rolesResource.get("approver").getRoleUserMembers());
        return userMapper.mapUserRepresentationListToUser(userRepresentations);
    }

    @Override
    public List<User> getUsers(List<String> userIds) {
        return usersResource
                .list()
                .stream()
                .filter(userRepresentation -> userIds.contains(userRepresentation.getId()))
                .map(userMapper::mapUserRepresentationToUser)
                .collect(Collectors.toList());
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        AccessTokenResponse accessTokenResponse = authzClient.obtainAccessToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return authTokenMapper.mapAccessTokenToAuthResponse(accessTokenResponse);
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequest request) {
        return authTokenMapper.mapAccessTokenToAuthResponse(refreshTokenProvider.refreshAuthToken(request));
    }

    @Override
    public void assignRole(RoleManagementRequest roleManagementRequest) {
        UserResource userResource = usersResource.get(roleManagementRequest.getUserId());
        userResource.roles().realmLevel().add(Collections.singletonList(getRoleRepresentation(roleManagementRequest.getRole())));
    }

    @Override
    public void revokeRole(RoleManagementRequest roleManagementRequest) {
        UserResource userResource = usersResource.get(roleManagementRequest.getUserId());
        userResource.roles().realmLevel().remove(Collections.singletonList(getRoleRepresentation(roleManagementRequest.getRole())));
    }

    @Override
    public List<RoleRepresentation> getRolesForUser(UserRequest userRequest) {
        return usersResource.get(userRequest.getUserId()).roles().getAll().getRealmMappings();
    }

    private RoleRepresentation getRoleRepresentation(String role) {
        return realmResource.roles().get(role).toRepresentation();
    }

    private void setUserPassword(String password, String userId) {
        UserResource userResource = usersResource.get(userId);

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(password);
        userResource.resetPassword(passwordCred);
    }

    private UserRepresentation mapCreateRequestToUserRepresentation(UserCreateRequest userCreateRequest) {
        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(userCreateRequest.getUsername());
        user.setFirstName(userCreateRequest.getFirstName());
        user.setLastName(userCreateRequest.getLastName());
        user.setEmail(userCreateRequest.getEmail());
        return user;
    }
}
