package dk.signfluent.service.document.api.provider;


import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.*;

import java.util.List;
import java.util.UUID;

public interface DocumentServiceApiProvider {
    DocumentContent getDocumentContent(String documentId) throws ApiException;

    public Document getDocumentDetails(String documentId) throws ApiException;

    public UUID signDocument(SignDocument signDocument) throws ApiException;

    List<DocumentRow> getDocumentList(List<String> documentIds) throws ApiException;

    String assignApprovers(AssignApprovers assignApprovers) throws ApiException;

    String rejectDocument(String documentId, String userId) throws ApiException;

    String uploadDocument(String userId, String description, String base64Content) throws ApiException;

}
