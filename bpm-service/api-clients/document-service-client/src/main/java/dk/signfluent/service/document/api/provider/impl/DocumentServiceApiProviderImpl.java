package dk.signfluent.service.document.api.provider.impl;

import dk.signfluent.document.service.api.DocumentControllerApi;
import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.document.service.model.ReceivedDocument;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceApiProviderImpl implements DocumentServiceApiProvider {
    private final DocumentControllerApi documentControllerApi;

    public DocumentServiceApiProviderImpl(DocumentControllerApi documentControllerApi) {
        this.documentControllerApi = documentControllerApi;
    }

    @Override
    public List<ReceivedDocument> getReceivedDocuments() {
        try {
            return documentControllerApi.getReceivedDocuments();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String assignApprovers(AssignApprovers assignApprovers) {
        try {
            return documentControllerApi.assignApprovers(assignApprovers).toString();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String rejectDocument(String documentId, String userId) {
        try {
            return documentControllerApi.rejectDocument(UUID.fromString(documentId), UUID.fromString(userId)).toString();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String uploadDocument(String base64Content, String userId) {
        try {
            return documentControllerApi.uploadDocument(base64Content, UUID.fromString(userId)).toString();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
