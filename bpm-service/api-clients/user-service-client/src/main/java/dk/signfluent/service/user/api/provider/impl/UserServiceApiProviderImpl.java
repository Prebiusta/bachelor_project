package dk.signfluent.service.user.api.provider.impl;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.service.user.api.service.RequestService;
import dk.signfluent.user.service.api.UserControllerApi;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.Device;
import dk.signfluent.user.service.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceApiProviderImpl implements UserServiceApiProvider {
    private final UserControllerApi userControllerApi;
    private final RequestService requestService;

    public UserServiceApiProviderImpl(UserControllerApi userControllerApi, RequestService requestService) {
        this.userControllerApi = userControllerApi;
        this.requestService = requestService;
    }

    @Override
    public List<User> getAvailableApprovers() {
        try {
            return userControllerApi.getAvailableApprovers();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Device> getDevicesForUser(String userId) {
        try {
            return userControllerApi.getDevicesForUser(requestService.generateUserBasedRequest(userId));
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getFCMTokensForUser(String userId) {
        try {
            return userControllerApi.getFCMTokensForUser(requestService.generateUserBasedRequest(userId));
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
