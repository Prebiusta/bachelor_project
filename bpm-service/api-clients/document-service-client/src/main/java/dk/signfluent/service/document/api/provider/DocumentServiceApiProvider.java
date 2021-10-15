package dk.signfluent.service.document.api.provider;


import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.document.service.model.ReceivedDocument;

import java.util.List;

public interface DocumentServiceApiProvider {
    List<ReceivedDocument> getReceivedDocuments();

    String assignApprovers(AssignApprovers assignApprovers);

    String rejectDocument(String documentId, String userId);

    String uploadDocument(String base64Content, String userId);

}
