package dk.signfluent.service.document.utils.Mappers;

import dk.signfluent.service.document.entity.Document;
import dk.signfluent.service.document.model.DocumentContent;
import dk.signfluent.service.document.model.DocumentRow;
import org.apache.tomcat.util.codec.binary.Base64;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    List<DocumentRow> documentToDocumentRow(List<Document> source);

    @Mapping(source = "uploader.uploaderId", target = "uploaderId")
    @Mapping(source = "uploader.uploadDate", target = "uploadDate")
    @Mapping(ignore = true, target = "content")
    DocumentContent documentToDocumentContent(Document source);

    @BeforeMapping
    default void contentToBase64(Document document, @MappingTarget DocumentContent documentContent) {
        documentContent.setContent(new String(Base64.encodeBase64(document.getContent())));
    }

    default DocumentRow map(Document source) {
        DocumentRow document = new DocumentRow();
        document.setDocumentId(source.getId());
        document.setDescription(source.getDescription());
        document.setUploaderId(source.getUploader().getUploaderId());
        document.setUploadDate(source.getUploader().getUploadDate());
        document.setStatus(source.getStatus());

        return document;
    }

}
