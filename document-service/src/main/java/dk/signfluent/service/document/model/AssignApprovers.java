package dk.signfluent.service.document.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AssignApprovers {
    private List<ApprovalOrderModel> approvers;
    private UUID delegatorId;
    private UUID documentId;
}
