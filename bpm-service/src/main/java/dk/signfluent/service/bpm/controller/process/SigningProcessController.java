package dk.signfluent.service.bpm.controller.process;

import dk.signfluent.service.bpm.model.DocumentWithContent;
import dk.signfluent.service.bpm.model.request.*;
import dk.signfluent.service.bpm.model.request.TaskIdRequest;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.bpm.service.DocumentService;
import dk.signfluent.service.bpm.service.UserService;
import dk.signfluent.service.bpm.utility.FormKey;
import dk.signfluent.service.bpm.utility.ProcessFormKey;
import dk.signfluent.user.service.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dk.signfluent.service.bpm.utility.AuthorizationTypes.*;

@RestController
@RequestMapping("/api/signingProcess")
public class SigningProcessController {
    private final DocumentService documentService;
    private final UserService userService;


    public SigningProcessController(DocumentService documentService, UserService userService) {
        this.documentService = documentService;
        this.userService = userService;
    }

    @PostMapping(value = "/uploadDocument")
    @ApiOperation(value = "Uploads a document", nickname = "uploadDocument")
    public void uploadDocument(@RequestBody UploadDocumentRequest uploadDocumentRequest) {
        documentService.uploadDocument(uploadDocumentRequest);
    }

    @PostMapping("/inspectDocument")
    @ApiOperation(value = "Inspect document and assign approvers", nickname = "inspectDocument")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    @PreAuthorize(DELEGATOR)
    public String inspectDocument(@RequestBody InspectDocumentRequest inspectDocumentRequest) {
        documentService.inspectDocument(inspectDocumentRequest);
        return "Done";
    }

    @PostMapping("/getDocumentsForInspection")
    @ApiOperation(value = "Returns documents needed inspection", nickname = "getDocumentsForInspection")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    @PreAuthorize(DELEGATOR)
    public List<DocumentResponse> getDocumentsForInspection() {
        return documentService.getDocumentsForInspection();
    }

    @PostMapping("/getDocumentDetails")
    @ApiOperation(value = "Returns document details for specified task", nickname = "getDocumentDetails")
    @FormKey({ProcessFormKey.INSPECT_DOCUMENT, ProcessFormKey.APPROVE_DOCUMENT})
    @PreAuthorize(DELEGATOR_OR_APPROVER)
    public DocumentWithContent getDocumentDetails(@RequestBody TaskIdRequest taskIdRequest) {
        return documentService.getDocumentDetails(taskIdRequest.getTaskId());
    }

    @PostMapping("/getActiveApprovers")
    @ApiOperation(value = "Get active approvers", nickname = "getActiveApprovers")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    @PreAuthorize(DELEGATOR)
    public List<User> getActiveApprovers() {
        return userService.getActiveApprovers();
    }

    @PostMapping("/getDocumentsForApproval")
    @ApiOperation(value = "Returns documents needed User's approval", nickname = "getDocumentsForApproval")
    @FormKey(ProcessFormKey.APPROVE_DOCUMENT)
    @PreAuthorize(APPROVER)
    public List<DocumentResponse> getDocumentsForApproval() {
        return documentService.getDocumentsForApproval();
    }

    @PostMapping("/approveDocument")
    @ApiOperation(value = "Submit approve document decision", nickname = "approveDocument")
    @FormKey(ProcessFormKey.APPROVE_DOCUMENT)
    @PreAuthorize(APPROVER)
    public String approveDocument(@RequestBody ApproverDocumentRequest approverDocumentRequest) {
        // Process approval handling
        return "Done";
    }

    @PostMapping("/getSignatureRequest")
    @ApiOperation(value = "Returns signature request for authenticated user", nickname = "getSignatureRequest")
    @FormKey(ProcessFormKey.SIGN_DOCUMENT)
    @PreAuthorize(APPROVER)
    public SignfluentSignatureRequest getSignatureRequest() {
        // TODO: Get all tasks waiting in signDocument task, get authenticated user ID from provider bearer token
        //  using UserProvider class. Map the response to required model.
        return new SignfluentSignatureRequest("123456", "signMe");
    }

    @PostMapping("/submitSignature")
    @ApiOperation(value = "Submits document signature", nickname = "submitSignature")
    @FormKey(ProcessFormKey.SIGN_DOCUMENT)
    @PreAuthorize(APPROVER)
    public String submitSignature(@RequestBody SignfluentSignature signfluentSignature) {
        // TODO: Handle the logic to process signature received from the device
        return "Done";
    }
}
