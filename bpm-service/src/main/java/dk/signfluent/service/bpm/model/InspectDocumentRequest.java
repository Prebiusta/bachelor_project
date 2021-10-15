package dk.signfluent.service.bpm.model;

import lombok.Data;

import java.util.Map;

@Data
public class InspectDocumentRequest {
    private Boolean isValid;
    private String taskId;
    private Map<Integer,Object> approvers;
}
