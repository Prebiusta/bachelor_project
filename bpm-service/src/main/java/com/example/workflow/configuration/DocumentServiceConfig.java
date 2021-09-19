package com.example.workflow.configuration;

import com.example.workflow.model.DocumentServiceConfigValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentServiceConfig {
    @Value("${bpm.service.svc.service.host}")
    private String url;

    @Value("${bpm.service.svc.service.port}")
    private String port;

    @Bean
    public DocumentServiceConfigValues bpmServiceConfigValues() {
        return new DocumentServiceConfigValues(url, port);
    }
}
