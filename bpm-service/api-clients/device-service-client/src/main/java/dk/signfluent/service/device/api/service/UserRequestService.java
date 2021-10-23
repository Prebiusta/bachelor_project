package dk.signfluent.service.device.api.service;

import dk.signfluent.ca.model.UserBasedRequest;
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
