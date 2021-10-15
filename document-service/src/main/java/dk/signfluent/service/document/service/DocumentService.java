package dk.signfluent.service.document.service;

import dk.signfluent.service.document.entity.*;
import dk.signfluent.service.document.entity.Signature;
import dk.signfluent.service.document.model.*;
import dk.signfluent.service.document.repository.DocumentRepository;
import dk.signfluent.service.document.utils.Enums.DocumentStatus;
import dk.signfluent.service.document.utils.Mappers.ApprovalOrderMapper;
import dk.signfluent.service.document.utils.Mappers.DocumentMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {

    private final DocumentRepository repository;
    private final DocumentMapper documentMapper;
    private final ApprovalOrderMapper orderMapper;

    public DocumentService(DocumentRepository repository, DocumentMapper documentMapper, ApprovalOrderMapper orderMapper) {
        this.repository = repository;
        this.documentMapper = documentMapper;
        this.orderMapper = orderMapper;
    }
    public DocumentContent getDocumentContent(UUID id) throws Exception {
        var document = repository.getDocumentById(id);
        if (document == null)
        {
            throw new Exception("Document not found");
        }

        return documentMapper.documentToDocumentContent(document);
    }
    public List<DocumentRow> getDocumentList(List<UUID> documentIds) throws Exception {
        List<Document> documents = repository.getDocumentsByIdIn(documentIds);
        if (documents.size() != documentIds.size())
        {
            throw new Exception("Documents not found");
        }

        return documentMapper.documentToDocumentRow(documents);
    }


    public UUID rejectDocument(UUID documentId, UUID rejectorId) throws Exception {
        var document = repository.getDocumentById(documentId);
        if (document == null)
        {
            throw new Exception("Document not found");
        }
        if (checkLock(document.getStatus()))
        {
            throw new Exception("Document is locked");
        }

        document.setRejector(new Rejector(rejectorId, new Date()));
        document.setStatus(DocumentStatus.REJECTED);

        return repository.save(document).getId();
    }

    public UUID assignApprovers(AssignApprovers assignApprovers) throws Exception {
        var document = repository.getDocumentById(assignApprovers.getDocumentId());
        if (document == null)
        {
            throw new Exception("Document not found");
        }
        if (checkLock(document.getStatus()))
        {
            throw new Exception("Document is locked");
        }
        if (document.getDelegator() != null)
        {
            throw new Exception("Document already delegated");
        }
        if (document.getApprovalOrder() != null)
        {
            throw new Exception("Document already delegated");
        }
        if (document.getStatus() != DocumentStatus.RECEIVED)
        {
            throw new Exception("Document wrong status");
        }

        document.setDelegator(new Delegator(assignApprovers.getDelegatorId(), new Date()));
        document.setApprovalOrder(orderMapper.modelToEntity(assignApprovers.getApprovers()));
        document.setStatus(DocumentStatus.FOR_APPROVAL);

        return repository.save(document).getId();
    }

    public UUID uploadDocument(UploadDocument document) {
        byte[] content = Base64.decodeBase64(document.getEncodedContent());
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(content);
            var doc = new Document(document.getUploaderId(), document.getDescription(), content, hash, DocumentStatus.RECEIVED);
            return repository.save(doc).getId();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public UUID signDocument(SignDocument signDocument) throws Exception {
        var document = repository.getDocumentById(signDocument.getDocumentId());
        if (document == null)
        {
            throw new Exception("Document not found");
        }
        if (checkLock(document.getStatus()))
        {
            throw new Exception("Document is locked");
        }
        if (document.getStatus() == DocumentStatus.RECEIVED)
        {
            throw new Exception("Document not delegated");
        }
        var signature = new Signature(signDocument.getSignature().getX509Pem(), signDocument.getSignature().getSignedContent(), new Date());
        document.getSignatures().add(signature);
        if (document.getApprovalOrder().size() == document.getSignatures().size())
        {
            document.setStatus(DocumentStatus.APPROVED);
        }
        return repository.save(document).getId();
    }

    private boolean checkLock(DocumentStatus status)
    {
        return status == DocumentStatus.REJECTED || status == DocumentStatus.APPROVED;
    }
}
