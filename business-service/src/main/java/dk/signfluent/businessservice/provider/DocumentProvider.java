package dk.signfluent.businessservice.provider;

import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DocumentProvider {
    private final DocumentServiceApiProvider documentServiceApiProvider;

    public DocumentProvider(DocumentServiceApiProvider documentServiceApiProvider) {
        this.documentServiceApiProvider = documentServiceApiProvider;
    }

    private List<DocumentRow> getAllDocuments() {
//        documentServiceApiProvider.getAllDocuments();
        return Collections.emptyList();
    }


}
