package dk.signfluent.service.bpm.model;

import dk.signfluent.document.service.model.ApprovalOrderModel;
import lombok.Data;

import java.util.List;

@Data
public class AssignApproversDocumentRequest {
    private String taskId;
    private Boolean approve;
    private String delegatorId;
    private List<ApprovalOrderModel> approvers;

}
