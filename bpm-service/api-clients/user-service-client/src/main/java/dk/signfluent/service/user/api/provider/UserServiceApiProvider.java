package dk.signfluent.service.user.api.provider;

import dk.signfluent.user.service.model.Device;
import dk.signfluent.user.service.model.User;

import java.util.List;

public interface UserServiceApiProvider {
    List<User> getAvailableApprovers();
    List<Device> getDevicesForUser(String userId);
    List<String> getFCMTokensForUser(String userId);
}
