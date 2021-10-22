package dk.signfluent.service.device.api.config;

import dk.signfluent.ca.api.DeviceControllerApi;
import dk.signfluent.ca.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.Controller;

@Configuration
public class DeviceServiceIntegrationConfig {
    private final DeviceServiceApiClientConfig deviceServiceApiClientConfig;

    public DeviceServiceIntegrationConfig(DeviceServiceApiClientConfig deviceServiceApiClientConfig) {
        this.deviceServiceApiClientConfig = deviceServiceApiClientConfig;
    }

    @Bean
    public DeviceControllerApi deviceControllerApi() {
        return new DeviceControllerApi(apiClient());
    }

    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(deviceServiceApiClientConfig.getBasePath());
        return apiClient;
    }
}
