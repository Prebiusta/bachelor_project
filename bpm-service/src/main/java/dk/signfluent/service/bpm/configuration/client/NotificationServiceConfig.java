package dk.signfluent.service.bpm.configuration.client;

import dk.signfluent.service.notification.api.config.NotificationServiceApiClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationServiceConfig {
    @Value("${notification.service.svc.service.host}")
    private String host;

    @Value("${notification.service.svc.service.port}")
    private String port;

    @Bean
    public NotificationServiceApiClientConfig notificationServiceApiClientConfig() {
        return () -> String.format("http://%s:%s", host, port);
    }
}
