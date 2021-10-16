package dk.signfluent.service.bpm.model.response;

import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.TaskIdRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentResponse extends TaskIdRequest {
    private Document document;
}
