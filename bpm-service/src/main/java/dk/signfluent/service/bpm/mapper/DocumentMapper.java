package dk.signfluent.service.bpm.mapper;

import dk.signfluent.document.service.model.DocumentContent;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.DocumentWithContent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    @Mapping(source = "uploaderId", target = "uploadedBy", qualifiedByName = "uuidToString")
    @Mapping(source = "uploadDate", target = "uploadedAt")
    Document mapDocumentRowToDocument(DocumentRow documentRow);

    List<Document> mapDocumentRowListToDocumentList(List<DocumentRow> documentRows);

    @Mapping(source = "content", target = "content", qualifiedByName = "bytesToString")
    @Mapping(source = "uploaderId", target = "uploadedBy", qualifiedByName = "uuidToString")
    @Mapping(source = "uploadDate", target = "uploadedAt")
    DocumentWithContent mapDocumentWithContent(DocumentContent documentContent);

    @Named("bytesToString")
    default String bytesToString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Named("uuidToString")
    default String uuidToString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }
}
