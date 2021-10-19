package dk.signfluent.service.bpm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentWithContent extends Document {
    private String content;
}
