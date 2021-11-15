package dk.signfluent.service.user.api.config;

import dk.signfluent.user.service.api.AuthControllerApi;
import dk.signfluent.user.service.api.UserControllerApi;
import dk.signfluent.user.service.invoker.ApiClient;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceIntegrationConfig {
    private final UserServiceApiClientConfig userServiceApiClientConfig;

    public UserServiceIntegrationConfig(UserServiceApiClientConfig userServiceApiClientConfig) {
        this.userServiceApiClientConfig = userServiceApiClientConfig;
    }

    @Bean
    public UserControllerApi userControllerApi() {
        return new UserControllerApi(apiClient());
    }

    @Bean
    public AuthControllerApi authControllerApi() {
        return new AuthControllerApi(apiClient());
    }

    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(userServiceApiClientConfig.getBasePath());
        return apiClient;
    }
}
