package dk.signfluent.service.notification.api.config;

import dk.signfluent.notification.service.api.NotificationControllerApi;
import dk.signfluent.notification.service.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationServiceIntegrationConfig {
    private final NotificationServiceApiClientConfig documentServiceApiClientConfig;

    public NotificationServiceIntegrationConfig(NotificationServiceApiClientConfig documentServiceApiClientConfig) {
        this.documentServiceApiClientConfig = documentServiceApiClientConfig;
    }

    @Bean
    public NotificationControllerApi notificationControllerApi() {
        return new NotificationControllerApi(apiClient());
    }

    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(documentServiceApiClientConfig.getBasePath());
        return apiClient;
    }
}
