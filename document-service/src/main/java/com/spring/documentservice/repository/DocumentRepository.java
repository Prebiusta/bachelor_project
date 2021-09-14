package com.spring.documentservice.repository;

import com.spring.documentservice.dataContext.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentRepository extends CrudRepository<Document, UUID> {

    Document getDocumentById(UUID id);
    Document getDocumentByContent(String content);
}
