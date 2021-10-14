package dk.signfluent.service.bpm.service;

import dk.signfluent.service.bpm.model.User;
import dk.signfluent.user.service.client.provider.UserApiProvider;
import org.jvnet.hk2.annotations.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private final UserApiProvider userApiProvider;

    public UserService(UserApiProvider userApiProvider) {
        this.userApiProvider = userApiProvider;
    }

    private List<User> getActiveApprovers() {
        // contact document-service to upload document
        return Collections.emptyList();
    }
}
