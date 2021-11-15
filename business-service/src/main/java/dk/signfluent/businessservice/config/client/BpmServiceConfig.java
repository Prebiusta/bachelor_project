package dk.signfluent.businessservice.config.client;

import dk.signfluent.service.bpm.api.BpmServiceApiClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BpmServiceConfig {
    @Value("${bpm.service.host}")
    private String host;

    @Value("${bpm.service.port}")
    private String port;

    @Bean
    public BpmServiceApiClientConfig bpmServiceApiClientConfig() {
        return () -> String.format("http://%s:%s", host, port);
    }
}
