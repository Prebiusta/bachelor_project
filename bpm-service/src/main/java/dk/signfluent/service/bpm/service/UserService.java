package dk.signfluent.service.bpm.service;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.model.User;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public class UserService {
    private final UserServiceApiProvider userServiceApiProvider;

    public UserService(UserServiceApiProvider userServiceApiProvider) {
        this.userServiceApiProvider = userServiceApiProvider;
    }

    public List<User> getActiveApprovers() {
        return userServiceApiProvider.getAvailableApprovers();
    }
}
