package dk.signfluent.service.bpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDocumentModel {
    private String taskId;
    private String documentId;
}