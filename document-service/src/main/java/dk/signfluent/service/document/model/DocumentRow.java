package dk.signfluent.service.document.model;

import dk.signfluent.service.document.utils.Enums.DocumentStatus;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
public class DocumentRow {
    private UUID documentId;
    private DocumentStatus status;
    private String description;
    private UUID uploaderId;
    private Date uploadDate;
}
