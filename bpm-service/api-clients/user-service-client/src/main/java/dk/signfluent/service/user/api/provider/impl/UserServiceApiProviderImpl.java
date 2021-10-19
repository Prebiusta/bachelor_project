package dk.signfluent.service.user.api.provider.impl;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.service.user.api.service.UserRequestService;
import dk.signfluent.user.service.api.UserControllerApi;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.Device;
import dk.signfluent.user.service.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceApiProviderImpl implements UserServiceApiProvider {
    private final UserControllerApi userControllerApi;
    private final UserRequestService userRequestService;

    public UserServiceApiProviderImpl(UserControllerApi userControllerApi, UserRequestService userRequestService) {
        this.userControllerApi = userControllerApi;
        this.userRequestService = userRequestService;
    }

    @Override
    public List<User> getAvailableApprovers() throws ApiException {
        return userControllerApi.getAvailableApprovers();
    }

    @Override
    public List<Device> getDevicesForUser(String userId) throws ApiException {
        return userControllerApi.getDevicesForUser(userRequestService.generateUserBasedRequest(userId));
    }

    @Override
    public List<String> getFCMTokensForUser(String userId) throws ApiException {
        return userControllerApi.getFCMTokensForUser(userRequestService.generateUserBasedRequest(userId));
    }
}
