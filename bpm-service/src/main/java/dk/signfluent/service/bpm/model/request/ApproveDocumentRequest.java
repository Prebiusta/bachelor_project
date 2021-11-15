package dk.signfluent.service.bpm.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApproveDocumentRequest extends ProcessIdRequest {
    private boolean approve;
    private String approverId;
}
