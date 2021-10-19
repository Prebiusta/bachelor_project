package dk.signfluent.service.user.api.service;

import dk.signfluent.user.service.model.UserBasedRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserRequestService {
    public UserBasedRequest generateUserBasedRequest(String userId) {
        UserBasedRequest userBasedRequest = new UserBasedRequest();
        userBasedRequest.setUserId(UUID.fromString(userId));
        return userBasedRequest;
    }
}
