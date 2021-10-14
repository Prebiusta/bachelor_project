package dk.signfluent.service.bpm.configuration.client;

import dk.signfluent.service.bpm.model.DocumentServiceConfigValues;
import dk.signfluent.service.document.api.config.DocumentServiceApiClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentServiceConfig {
    @Value("${document.service.svc.service.host}")
    private String host;

    @Value("${document.service.svc.service.port}")
    private String port;

    @Bean
    public DocumentServiceApiClientConfig documentServiceApiClientConfig() {
        return () -> String.format("http://%s:%s", host, port);
    }
}
