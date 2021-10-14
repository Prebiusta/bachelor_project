package dk.signfluent.service.bpm.service;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private final UserServiceApiProvider userServiceApiProvider;

    public UserService(UserServiceApiProvider userServiceApiProvider) {
        this.userServiceApiProvider = userServiceApiProvider;
    }

    public List<User> getActiveApprovers() {
        try {
            return userServiceApiProvider.getAvailableApprovers();
        } catch (ApiException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
