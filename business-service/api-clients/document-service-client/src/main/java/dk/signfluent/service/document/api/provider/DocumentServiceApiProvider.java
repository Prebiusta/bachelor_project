package dk.signfluent.service.document.api.provider;


import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.document.service.model.DocumentRow;

import java.util.List;

public interface DocumentServiceApiProvider {
    DocumentContent getDocumentDetails(String documentId) throws ApiException;

    List<DocumentRow> getDocumentList(List<String> documentIds) throws ApiException;

    String assignApprovers(AssignApprovers assignApprovers) throws ApiException;

    String rejectDocument(String documentId, String userId) throws ApiException;

    String uploadDocument(String userId, String description, String base64Content) throws ApiException;

}
