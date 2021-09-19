package com.example.workflow.provider;

import com.example.workflow.model.DocumentServiceConfigValues;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!docker")
public class ServiceUrlProviderImpl implements ServiceUrlProvider {
    private final DocumentServiceConfigValues documentServiceConfigValues;

    public ServiceUrlProviderImpl(DocumentServiceConfigValues documentServiceConfigValues) {
        this.documentServiceConfigValues = documentServiceConfigValues;
    }

    @Override
    public String getDocumentServiceUrl() {
        return String.format("http://%s:%s", documentServiceConfigValues.getUrl(), documentServiceConfigValues.getPort());
    }
}
