package dk.signfluent.service.bpm.api;


import dk.signfluent.bpm.service.api.SigningProcessControllerApi;
import dk.signfluent.bpm.service.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BpmServiceIntegrationConfig {
    private final BpmServiceApiClientConfig bpmServiceApiClientConfig;

    public BpmServiceIntegrationConfig(BpmServiceApiClientConfig bpmServiceApiClientConfig) {
        this.bpmServiceApiClientConfig = bpmServiceApiClientConfig;
    }

    @Bean
    public SigningProcessControllerApi signingProcessControllerApi() {
        return new SigningProcessControllerApi(apiClient());
    }

    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(bpmServiceApiClientConfig.getBasePath());
        return apiClient;
    }
}
