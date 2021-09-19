package com.spring.documentservice.config;

import com.spring.documentservice.models.KubernetesEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KubernetesEnv {
    @Value("${my.url}")
    private String documentServiceURL;

    @Value("${my.port}")
    private String documentServicePort;

    @Bean
    public KubernetesEnvironment kubernetesEnvironment() {
        return new KubernetesEnvironment(documentServiceURL, documentServicePort);
    }
}
