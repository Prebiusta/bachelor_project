package dk.signfluent.businessservice.model.response;

import dk.signfluent.businessservice.model.ApprovalOrderResponse;
import dk.signfluent.document.service.model.*;
import dk.signfluent.user.service.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDetailsResponse {
   private String documentId;
   private String description;
   private String status;

   private byte[] content;
   private byte[] hash;
   private List<ApprovalOrderResponse> approvalOrder;
   private List<Signature0> signatures;

   private UserActionResponse uploadedBy;
   private UserActionResponse delegatedBy;
   private UserActionResponse rejectedBy;
}
