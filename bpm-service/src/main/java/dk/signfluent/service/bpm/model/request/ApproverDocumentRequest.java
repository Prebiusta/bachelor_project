package dk.signfluent.service.bpm.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApproverDocumentRequest extends ProcessIdRequest {
    private boolean approve;
}
