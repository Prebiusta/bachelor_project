package dk.signfluent.businessservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentWithProcessResponse {
    private String processId;
    private DocumentResponse document;
}
