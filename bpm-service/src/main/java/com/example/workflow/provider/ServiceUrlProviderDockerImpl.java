package com.example.workflow.provider;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("docker")
public class ServiceUrlProviderDockerImpl implements ServiceUrlProvider {
    @Override
    public String getDocumentServiceUrl() {
        return "http://document-service:8080";
    }
}
