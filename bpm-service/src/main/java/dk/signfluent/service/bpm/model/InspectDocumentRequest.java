package dk.signfluent.service.bpm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class InspectDocumentRequest extends TaskIdRequest {
    private Boolean isValid;
    private String delegatorId;
    private List<Object> approvers;
}
