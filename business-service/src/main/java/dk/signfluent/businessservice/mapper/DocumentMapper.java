package dk.signfluent.businessservice.mapper;

import dk.signfluent.bpm.service.model.DocumentWithContent;
import dk.signfluent.businessservice.model.ApprovalOrderResponse;
import dk.signfluent.businessservice.model.response.DocumentDetailsResponse;
import dk.signfluent.businessservice.model.response.DocumentResponse;
import dk.signfluent.businessservice.model.response.UserActionResponse;
import dk.signfluent.businessservice.service.UserService;
import dk.signfluent.document.service.model.*;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.User;
import lombok.Setter;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public abstract class DocumentMapper {
    @Autowired
    @Setter
    protected UserService userService;

    @Mapping(source = "uploadDate", target = "uploadedAt")
    public abstract DocumentResponse mapDocumentRowToDocument(DocumentRow documentRow);

    @Mapping(source = "uploadDate", target = "uploadedAt")
    public abstract DocumentWithContent mapDocumentWithContent(DocumentContent documentContent);

    @Mapping(source = "id", target = "documentId")
    @Mapping(source = "uploader", target = "uploadedBy")
    @Mapping(source = "delegator", target = "delegatedBy")
    @Mapping(source = "rejector", target = "rejectedBy")
    public abstract DocumentDetailsResponse convertDocumentToDocumentDetailsResponse(Document document);

    @Mapping(source = "approverId", target = "user")
    public abstract ApprovalOrderResponse approvalOrderToApprovalOrderResponse(ApprovalOrder approvalOrder);

    @Mapping(source = "rejectDate", target = "date")
    @Mapping(source = "rejectorId", target = "user")
    public  abstract UserActionResponse rejectorToUserActionResponse(Rejector rejector);

    @Mapping(source = "delegateDate", target = "date")
    @Mapping(source = "delegatorId", target = "user")
    public  abstract UserActionResponse delegatorToUserActionResponse(Delegator delegator);

    @Mapping(source = "uploadDate", target = "date")
    @Mapping(source = "uploaderId", target = "user")
    public abstract UserActionResponse uploaderToUserActionResponse(Uploader uploader);

    public String bytesToString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String uuidToString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }

    public User userIdToUser(UUID uuid) throws ApiException {
        return userService.getUserDetails(uuid.toString());
    }
}
