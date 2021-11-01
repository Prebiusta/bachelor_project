package dk.signfluent.service.bpm.model.request;


import dk.signfluent.document.service.model.ApprovalOrderModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class AssignApproversRequest extends ProcessIdRequest {
    private List<ApprovalOrderModel> approvers;
}
