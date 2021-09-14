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

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    public DocumentReturnModel getDocumentContent(UUID id) {
        // poc purposes code
        demo();

        Document document = repository.getDocumentByContent("content of document");

        return DocumentMapper.INSTANCE.sourceToDestination(document);

    }
    private void demo()
    {
        repository.save(new Document("content of document", Arrays.asList("signature1", "signature2")));
    }
}
