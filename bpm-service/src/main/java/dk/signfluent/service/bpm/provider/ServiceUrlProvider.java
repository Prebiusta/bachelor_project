package dk.signfluent.service.bpm.provider;

import dk.signfluent.service.bpm.model.DocumentServiceConfigValues;
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
