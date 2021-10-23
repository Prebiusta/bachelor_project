package dk.signfluent.service.user.api.provider;

import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.User;

import java.util.List;

public interface UserServiceApiProvider {
    List<User> getAvailableApprovers() throws ApiException;
}
