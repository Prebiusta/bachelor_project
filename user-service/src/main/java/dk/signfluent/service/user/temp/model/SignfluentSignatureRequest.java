package dk.signfluent.service.user.temp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignfluentSignatureRequest {
    private String hash;
    private String taskId;
}
