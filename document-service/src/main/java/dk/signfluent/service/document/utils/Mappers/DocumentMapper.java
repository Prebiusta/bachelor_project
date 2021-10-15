package dk.signfluent.service.document.utils.Mappers;

import dk.signfluent.service.document.entity.Document;
import dk.signfluent.service.document.model.DocumentContent;
import dk.signfluent.service.document.model.DocumentRow;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    List<DocumentRow> documentToDocumentRow(List<Document> source);

    DocumentContent documentToDocumentContent(Document source);

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
