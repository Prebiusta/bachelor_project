package dk.signfluent.businessservice.service;

import dk.signfluent.businessservice.provider.UserProvider;
import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.User;
import dk.signfluent.user.service.model.UserCreateRequest;
import dk.signfluent.user.service.model.UserCreateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserServiceApiProvider userServiceApiProvider;
    private final UserProvider userProvider;

    public UserService(UserServiceApiProvider userServiceApiProvider, UserProvider userProvider) {
        this.userServiceApiProvider = userServiceApiProvider;
        this.userProvider = userProvider;
    }

    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) throws ApiException {
        return userServiceApiProvider.createUserAccount(userCreateRequest);
    }

    public List<User> getAllUsers() throws ApiException {
        return userServiceApiProvider.getAllUsers();
    }

    public User getUserDetails(String userId) throws ApiException {
        return getUser(userId);
    }

    public User getCurrentUserDetails() throws ApiException {
        return getUser(userProvider.getCurrentUserId());
    }

    private User getUser(String userId) throws ApiException {
        return userServiceApiProvider.getUsersByIds(List.of(userId)).get(0);
    }
}
