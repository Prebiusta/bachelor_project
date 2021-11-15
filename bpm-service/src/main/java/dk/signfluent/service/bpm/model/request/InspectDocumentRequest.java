package dk.signfluent.service.bpm.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InspectDocumentRequest extends ProcessIdRequest {
    private Boolean isValid;
    private String delegatorId;
}
