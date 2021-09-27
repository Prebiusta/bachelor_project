package dk.signfluent.service.document.service;

import dk.signfluent.service.document.entity.DocumentEntity;
import dk.signfluent.service.document.model.DocumentReturnModel;
import dk.signfluent.service.document.repository.DocumentRepository;
import dk.signfluent.service.document.utils.DocumentMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class DocumentService {

    private final DocumentRepository repository;
    private final DocumentMapper mapper;

    public DocumentService(DocumentRepository repository, DocumentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        demo();
    }

    public DocumentReturnModel getDocumentById(UUID id) {
        // poc purposes code
        DocumentEntity document = repository.getDocumentByContent("content of document");
        // should be:
        // Document document = repository.getDocumentById(id);

        return mapper.sourceToDestination(document);
    }

    private void demo() {
        repository.save(new DocumentEntity("content of document", Arrays.asList("signature1", "signature2")));
    }
}
