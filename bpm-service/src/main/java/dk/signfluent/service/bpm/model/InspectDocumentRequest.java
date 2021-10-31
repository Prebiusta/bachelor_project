package dk.signfluent.service.bpm.model;

import dk.signfluent.user.service.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class InspectDocumentRequest extends TaskIdRequest {
    private Boolean isValid;
    private String delegatorId;
    private List<UserDTO> approvers;
}
