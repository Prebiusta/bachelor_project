package dk.signfluent.service.document.api.provider.impl;

import dk.signfluent.document.service.api.DocumentControllerApi;
import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.*;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import dk.signfluent.service.document.api.service.DocumentRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DocumentServiceApiProviderImpl implements DocumentServiceApiProvider {
    private final DocumentControllerApi documentControllerApi;
    private final DocumentRequestService documentRequestService;

    public DocumentServiceApiProviderImpl(DocumentControllerApi documentControllerApi, DocumentRequestService documentRequestService) {
        this.documentControllerApi = documentControllerApi;
        this.documentRequestService = documentRequestService;
    }

    @Override
    public DocumentContent getDocumentContent(String documentId) throws ApiException {
        return documentControllerApi.getDocumentContent(UUID.fromString(documentId));
    }

    @Override
    public Document getDocumentDetails(String documentId) throws ApiException {
        return documentControllerApi.getDocumentDetails(documentId);
    }

    @Override
    public List<DocumentRow> getDocumentList(List<String> documentIds) throws ApiException {
        List<UUID> docIds = documentIds.stream().map(UUID::fromString).collect(Collectors.toList());
        return documentControllerApi.getDocumentList(docIds);
    }

    @Override
    public String assignApprovers(AssignApprovers assignApprovers) throws ApiException {
        return documentControllerApi.assignApprovers(assignApprovers).toString();
    }

    @Override
    public String rejectDocument(String documentId, String userId) throws ApiException {
        return documentControllerApi.rejectDocument(UUID.fromString(documentId), UUID.fromString(userId)).toString();
    }

    @Override
    public UUID signDocument(SignDocument signDocument) throws ApiException {
        return documentControllerApi.signDocument(signDocument);
    }

    @Override
    public String uploadDocument(String userId, String description, String base64Content) throws ApiException {
        return documentControllerApi.uploadDocument(documentRequestService.generateUploadDocumentRequest(userId, description, base64Content)).toString();
    }
}
