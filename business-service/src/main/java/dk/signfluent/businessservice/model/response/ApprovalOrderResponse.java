package dk.signfluent.businessservice.model.response;

import dk.signfluent.user.service.model.User;
import lombok.Data;

@Data
public class ApprovalOrderResponse {
    private User user;
    private Integer approvingOrder;
    private String id;
}
