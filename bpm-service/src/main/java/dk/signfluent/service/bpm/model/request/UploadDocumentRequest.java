package dk.signfluent.service.bpm.model.request;

import lombok.Data;
@Data
public class UploadDocumentRequest {
    private String document;
    private String description;
}
