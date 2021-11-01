package dk.signfluent.service.bpm.model.response;

import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.request.ProcessIdRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentResponse extends ProcessIdRequest {
    private Document document;
}
