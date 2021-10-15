package dk.signfluent.service.document.api.provider;


import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.document.service.model.DocumentRow;

import java.util.List;

public interface DocumentServiceApiProvider {
    DocumentContent getDocumentDetails(String documentId);

    List<DocumentRow> getDocumentList(List<String> documentIds);

    String assignApprovers(AssignApprovers assignApprovers);

    String rejectDocument(String documentId, String userId);

    String uploadDocument(String userId, String description, String base64Content);

}
