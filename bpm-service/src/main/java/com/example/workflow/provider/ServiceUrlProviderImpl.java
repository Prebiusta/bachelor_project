package com.example.workflow.provider;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!docker")
public class ServiceUrlProviderImpl implements ServiceUrlProvider {
    @Override
    public String getDocumentServiceUrl() {
        return "http://localhost:8080";
    }
}
