package com.spring.documentservice.services;

import com.spring.documentservice.dataContext.Document;
import com.spring.documentservice.models.DocumentReturnModel;
import com.spring.documentservice.repository.DocumentRepository;
import com.spring.documentservice.utils.DocumentMapper;
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
        Document document = repository.getDocumentByContent("content of document");
        // should be:
        // Document document = repository.getDocumentById(id);

        return mapper.sourceToDestination(document);

    }
    private void demo()
    {
        repository.save(new Document("content of document", Arrays.asList("signature1", "signature2")));
    }
}
