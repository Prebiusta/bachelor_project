package dk.signfluent.businessservice.provider;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.Document;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentProvider {
    private final DocumentServiceApiProvider documentServiceApiProvider;
    private final UserProvider userProvider;

    public DocumentProvider(DocumentServiceApiProvider documentServiceApiProvider, UserProvider userProvider) {
        this.documentServiceApiProvider = documentServiceApiProvider;
        this.userProvider = userProvider;
    }

    public List<DocumentRow> getAllDocuments() throws ApiException {
        return documentServiceApiProvider.getAllDocuments();
    }

    public List<DocumentRow> getAllDocumentsForApprover() throws ApiException {
        return documentServiceApiProvider.getAllDocumentsForUploader(userProvider.getCurrentUserId());
    }

    public Document getDocumentDetails(String documentId) throws ApiException {
        return documentServiceApiProvider.getDocumentDetails(documentId);
    }


}
