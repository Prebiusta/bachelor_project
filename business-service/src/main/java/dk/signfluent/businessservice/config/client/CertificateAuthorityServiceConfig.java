package dk.signfluent.businessservice.config.client;

import dk.signfluent.ca.api.config.CertificateAuthorityApiClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CertificateAuthorityServiceConfig {
    @Value("${ca.svc.service.host}")
    private String host;

    @Value("${ca.svc.service.port}")
    private String port;

    @Bean
    public CertificateAuthorityApiClientConfig certificateAuthorityApiClientConfig() {
        return () -> String.format("http://%s:%s", host, port);
    }
}
