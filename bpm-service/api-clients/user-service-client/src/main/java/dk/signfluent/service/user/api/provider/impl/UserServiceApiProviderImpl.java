package dk.signfluent.service.user.api.provider.impl;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.api.UserControllerApi;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceApiProviderImpl implements UserServiceApiProvider {
    private final UserControllerApi userControllerApi;

    public UserServiceApiProviderImpl(UserControllerApi userControllerApi) {
        this.userControllerApi = userControllerApi;
    }

    @Override
    public List<User> getAvailableApprovers() throws ApiException {
        return userControllerApi.getAvailableApprovers();
    }
}
