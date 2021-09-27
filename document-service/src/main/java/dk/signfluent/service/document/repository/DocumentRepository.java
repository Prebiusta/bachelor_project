package dk.signfluent.service.document.repository;

import dk.signfluent.service.document.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentRepository extends CrudRepository<DocumentEntity, UUID> {
    DocumentEntity getDocumentById(UUID id);
    DocumentEntity getDocumentByContent(String content);
}
