package dk.signfluent.service.bpm.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UploadDocumentRequest extends UserBasedRequest {
    private String document;
    private String description;
}
