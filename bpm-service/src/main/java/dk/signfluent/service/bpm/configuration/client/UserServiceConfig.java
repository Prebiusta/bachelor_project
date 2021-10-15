package dk.signfluent.service.bpm.configuration.client;

import dk.signfluent.service.user.api.config.UserServiceApiClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
    @Value("${user.service.svc.service.host}")
    private String host;

    @Value("${user.service.svc.service.port}")
    private String port;

    @Bean
    UserServiceApiClientConfig userServiceApiClientConfig() {
        return () -> String.format("http://%s:%s", host, port);
    }
}
