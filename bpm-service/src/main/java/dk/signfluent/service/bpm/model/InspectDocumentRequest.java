package dk.signfluent.service.bpm.model;

import lombok.Data;

import java.util.List;

@Data
public class InspectDocumentRequest extends TaskIdRequest {
    private Boolean isValid;
    private String delegatorId;
    private List<Object> approvers;
}
