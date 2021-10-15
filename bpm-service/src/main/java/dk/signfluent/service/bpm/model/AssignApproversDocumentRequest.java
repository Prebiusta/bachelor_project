package dk.signfluent.service.bpm.model;

import lombok.Data;

import java.util.List;

@Data
public class AssignApproversDocumentRequest {
    private String taskId;
    private Boolean approve;
    private String delegatorId;
    private List<User> approvers;

}
