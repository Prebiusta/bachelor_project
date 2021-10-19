package dk.signfluent.service.bpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
   private String description;
   private String uploadedBy;
   private String status;
   private OffsetDateTime uploadedAt;
}
