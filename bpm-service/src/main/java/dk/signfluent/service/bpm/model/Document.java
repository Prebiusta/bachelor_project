package dk.signfluent.service.bpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
   private String content;
   private String description;
   private String uploadedBy;
   private String status;
   private String uploadedDate;

}
