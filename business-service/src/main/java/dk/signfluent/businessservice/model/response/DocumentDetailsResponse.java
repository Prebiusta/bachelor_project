package dk.signfluent.businessservice.model.response;

import dk.signfluent.document.service.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDetailsResponse {
   private String documentId;
   private String description;
   private String status;

   private byte[] content;
   private String hash;
   private List<ApprovalOrderResponse> approvalOrder;
   private List<Signature0> signatures;

   private UserActionResponse uploadedBy;
   private UserActionResponse delegatedBy;
   private UserActionResponse rejectedBy;
}
