package dk.signfluent.businessservice.config.client;

import dk.signfluent.service.device.api.config.DeviceServiceApiClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceServiceConfig {
    @Value("${device.service.svc.service.host}")
    private String host;

    @Value("${device.service.svc.service.port}")
    private String port;

    @Bean
    public DeviceServiceApiClientConfig deviceServiceApiClientConfig() {
        return () -> String.format("http://%s:%s", host, port);
    }
}
