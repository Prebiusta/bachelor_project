package dk.signfluent.service.document.api.provider;


import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.document.service.model.Document;
import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.document.service.model.DocumentRow;

import java.util.List;

public interface DocumentServiceApiProvider {
    DocumentContent getBasicDocumentDetails(String documentId) throws ApiException;

    List<DocumentRow> getDocumentList(List<String> documentIds) throws ApiException;

    List<DocumentRow> getAllDocuments() throws ApiException;

    List<DocumentRow> getAllDocumentsForUploader(String userId) throws ApiException;

    Document getDocumentDetails(String documentId) throws ApiException;

    String assignApprovers(AssignApprovers assignApprovers) throws ApiException;

    String rejectDocument(String documentId, String userId) throws ApiException;

    String uploadDocument(String userId, String description, String base64Content) throws ApiException;

}
