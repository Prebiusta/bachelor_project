package dk.signfluent.businessservice.service;

import dk.signfluent.businessservice.mapper.DocumentMapper;
import dk.signfluent.businessservice.model.response.DocumentDetailsResponse;
import dk.signfluent.businessservice.model.response.DocumentResponse;
import dk.signfluent.businessservice.provider.DocumentProvider;
import dk.signfluent.businessservice.provider.UserProvider;
import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.Document;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private final DocumentServiceApiProvider documentServiceApiProvider;
    private final UserProvider userProvider;
    private final DocumentProvider documentProvider;
    private final DocumentMapper documentMapper;

    public DocumentService(DocumentServiceApiProvider documentServiceApiProvider, UserProvider userProvider, DocumentProvider documentProvider, DocumentMapper documentMapper) {
        this.documentServiceApiProvider = documentServiceApiProvider;
        this.userProvider = userProvider;
        this.documentProvider = documentProvider;
        this.documentMapper = documentMapper;
    }

    public List<DocumentResponse> getAllDocuments() throws Exception {
        return documentProvider.convertDocumentRowsToDocuments(documentServiceApiProvider.getAllDocuments());
    }

    public List<DocumentResponse> getAllDocumentsForApprover() throws Exception {
        List<DocumentRow> allDocumentsForUploader = documentServiceApiProvider.getAllDocumentsForUploader(userProvider.getCurrentUserId());
        return documentProvider.convertDocumentRowsToDocuments(allDocumentsForUploader);
    }

    public DocumentDetailsResponse getDocumentDetails(String documentId) throws ApiException {
        Document document = documentServiceApiProvider.getDocumentDetails(documentId);
        return documentMapper.convertDocumentToDocumentDetailsResponse(document);
    }
}
