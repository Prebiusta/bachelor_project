package dk.signfluent.businessservice.model.response;

import dk.signfluent.user.service.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentResponse {
   private String documentId;
   private String description;
   private User uploadedBy;
   private String status;
   private OffsetDateTime uploadedAt;
   private boolean isLocked;
}
