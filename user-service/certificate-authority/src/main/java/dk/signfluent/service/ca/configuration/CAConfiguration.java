package dk.signfluent.service.ca.configuration;

import dk.signfluent.service.ca.model.CAConfigurationValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CAConfiguration {
    @Value("${certificate.path}")
    private String certificatePath;

    @Value("${certificate.keystore.password}")
    private String keystorePassword;

    @Value("${certificate.keystore.type}")
    private String keystoreType;

    @Bean
    public CAConfigurationValues caConfigurationValues() {
        return new CAConfigurationValues(
                certificatePath,
                keystorePassword,
                keystoreType
        );
    }
}
