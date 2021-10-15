package dk.signfluent.service.document.api.provider.impl;

import dk.signfluent.document.service.api.DocumentControllerApi;
import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.document.service.model.ReceivedDocument;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import dk.signfluent.service.document.api.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DocumentServiceApiProviderImpl implements DocumentServiceApiProvider {
    private final DocumentControllerApi documentControllerApi;
    private final RequestService requestService;

    public DocumentServiceApiProviderImpl(DocumentControllerApi documentControllerApi, RequestService requestService) {
        this.documentControllerApi = documentControllerApi;
        this.requestService = requestService;
    }

    @Override
    public DocumentContent getDocumentDetails(String documentId) {
        try {
            return documentControllerApi.getDocumentContent(UUID.fromString(documentId));
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DocumentRow> getDocumentList(List<String> documentIds) {
        try {
            List<UUID> docIds = documentIds.stream().map(UUID::fromString).collect(Collectors.toList());
            return documentControllerApi.getDocumentList(docIds);
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
    public String uploadDocument(String userId, String description, String base64Content) {
        try {
            return documentControllerApi.uploadDocument(requestService.generateUploadDocumentRequest(userId, description, base64Content)).toString();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
