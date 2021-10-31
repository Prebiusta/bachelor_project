package dk.signfluent.ca.api.config;

import dk.signfluent.ca.api.CertificateControllerApi;
import dk.signfluent.ca.api.ValidationControllerApi;
import dk.signfluent.ca.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CertificateAuthorityIntegrationConfig {
    private final CertificateAuthorityApiClientConfig certificateAuthorityApiClientConfig;

    public CertificateAuthorityIntegrationConfig(CertificateAuthorityApiClientConfig certificateAuthorityApiClientConfig) {
        this.certificateAuthorityApiClientConfig = certificateAuthorityApiClientConfig;
    }

    @Bean
    public ValidationControllerApi validationControllerApi() {
        return new ValidationControllerApi(apiClient());
    }

    @Bean
    public CertificateControllerApi certificateControllerApi() {
        return new CertificateControllerApi(apiClient());
    }

    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(certificateAuthorityApiClientConfig.getBasePath());
        return apiClient;
    }
}
