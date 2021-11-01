package dk.signfluent.service.bpm.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SignfluentSignatureRequest extends ProcessIdRequest {
    private String contentToBeSigned;

    public SignfluentSignatureRequest(String taskId, String contentToBeSigned) {
        super(taskId);
        this.contentToBeSigned = contentToBeSigned;
    }
}
