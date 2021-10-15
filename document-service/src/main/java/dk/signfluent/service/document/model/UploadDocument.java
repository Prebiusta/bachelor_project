package dk.signfluent.service.document.model;

import lombok.Data;

import java.util.UUID;

@Data
public class UploadDocument {
    UUID uploaderId;
    String description;
    String encodedContent;
}
