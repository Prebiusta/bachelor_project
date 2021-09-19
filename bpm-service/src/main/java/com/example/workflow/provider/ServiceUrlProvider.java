package com.example.workflow.provider;

import com.example.workflow.model.DocumentServiceConfigValues;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class ServiceUrlProvider {
    private final DocumentServiceConfigValues documentServiceConfigValues;

    public ServiceUrlProvider(DocumentServiceConfigValues documentServiceConfigValues) {
        this.documentServiceConfigValues = documentServiceConfigValues;
    }

    public String getDocumentServiceUrl() {
        return String.format("http://%s:%s", documentServiceConfigValues.getUrl(), documentServiceConfigValues.getPort());
    }
}
