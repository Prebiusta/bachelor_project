package dk.signfluent.service.document.model;

import dk.signfluent.service.document.utils.Enums.DocumentStatus;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class DocumentContent {
    private UUID id;
    private DocumentStatus status;
    private String content;
    private String description;
    private UUID uploaderId;
    private Date uploadDate;
    private boolean isLocked;
}
