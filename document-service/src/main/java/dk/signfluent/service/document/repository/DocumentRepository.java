package dk.signfluent.service.document.repository;

import dk.signfluent.service.document.entity.Document;
import dk.signfluent.service.document.utils.Enums.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<Document, UUID> {
    List<Document> getDocumentsByIdIn(List<UUID> ids);

    Document getDocumentById(UUID id);

    boolean existsDocumentByHashAndStatus(byte[] hash, DocumentStatus status);
}
