package dk.signfluent.service.document.api.config;


import dk.signfluent.document.service.api.DocumentControllerApi;
import dk.signfluent.document.service.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentServiceIntegrationConfig {
    private final DocumentServiceApiClientConfig documentServiceApiClientConfig;

    public DocumentServiceIntegrationConfig(DocumentServiceApiClientConfig documentServiceApiClientConfig) {
        this.documentServiceApiClientConfig = documentServiceApiClientConfig;
    }

    @Bean
    public DocumentControllerApi documentControllerApi() {
        return new DocumentControllerApi(apiClient());
    }

    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(documentServiceApiClientConfig.getBasePath());
        return apiClient;
    }
}
