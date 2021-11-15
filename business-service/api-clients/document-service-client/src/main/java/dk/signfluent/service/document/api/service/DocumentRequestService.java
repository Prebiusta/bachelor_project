package dk.signfluent.service.document.api.service;

import dk.signfluent.document.service.model.UploadDocument;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DocumentRequestService {
    public UploadDocument generateUploadDocumentRequest(String uploaderId, String description, String content) {
        UploadDocument uploadDocument = new UploadDocument();
        uploadDocument.setUploaderId(UUID.fromString(uploaderId));
        uploadDocument.setDescription(description);
        uploadDocument.setEncodedContent(content);
        return uploadDocument;
    }
}
