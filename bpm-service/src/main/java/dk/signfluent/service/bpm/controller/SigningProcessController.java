package dk.signfluent.service.bpm.controller;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.service.bpm.model.DocumentWithContent;
import dk.signfluent.service.bpm.model.request.*;
import dk.signfluent.service.bpm.model.response.BaseResponse;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.bpm.service.DocumentService;
import dk.signfluent.service.bpm.service.UserService;
import dk.signfluent.service.bpm.utility.FormKey;
import dk.signfluent.service.bpm.utility.ProcessFormKey;
import dk.signfluent.user.service.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public BaseResponse uploadDocument(@RequestBody UploadDocumentRequest uploadDocumentRequest) throws ApiException {
        documentService.uploadDocument(uploadDocumentRequest);
        return BaseResponse.successfulResponse();
    }

    @PostMapping("/inspectDocument")
    @ApiOperation(value = "Inspect document and assign approvers", nickname = "inspectDocument")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public BaseResponse inspectDocument(@RequestBody InspectDocumentRequest inspectDocumentRequest) {
        documentService.inspectDocument(inspectDocumentRequest);
        return BaseResponse.successfulResponse();
    }

    @PostMapping("/getDocumentsForInspection")
    @ApiOperation(value = "Returns documents needed inspection", nickname = "getDocumentsForInspection")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public List<DocumentResponse> getDocumentsForInspection() throws Exception {
        return documentService.getDocumentsForInspection();
    }

    @PostMapping("/getDocumentDetails")
    @ApiOperation(value = "Returns document details for specified task", nickname = "getDocumentDetails")
    @FormKey({ProcessFormKey.INSPECT_DOCUMENT, ProcessFormKey.APPROVE_DOCUMENT})
    public DocumentWithContent getDocumentDetails(@RequestBody ProcessIdRequest processIdRequest) {
        return documentService.getDocumentDetails(processIdRequest.getProcessId());
    }

    @PostMapping("/getActiveApprovers")
    @ApiOperation(value = "Get active approvers", nickname = "getActiveApprovers")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public List<User> getActiveApprovers() {
        return userService.getActiveApprovers();
    }

    @PostMapping("/assignApprovers")
    @ApiOperation(value = "Assign approvers to a document", nickname = "assignApprovers")
    @FormKey(ProcessFormKey.ASSIGN_APPROVERS)
    public BaseResponse assignApprovers(@RequestBody AssignApproversRequest assignApproversRequest) {
        documentService.assignApprovers(assignApproversRequest);
        return BaseResponse.successfulResponse();
    }

    @PostMapping("/getDocumentsForApproval")
    @ApiOperation(value = "Returns documents needed User's approval", nickname = "getDocumentsForApproval")
    @FormKey(ProcessFormKey.APPROVE_DOCUMENT)
    public List<DocumentResponse> getDocumentsForApproval(@RequestBody UserBasedRequest userBasedRequest) throws Exception {
        return documentService.getDocumentsForApproval(userBasedRequest);
    }

    @PostMapping("/approveDocument")
    @ApiOperation(value = "Submit approve document decision", nickname = "approveDocument")
    @FormKey(ProcessFormKey.APPROVE_DOCUMENT)
    public BaseResponse approveDocument(@RequestBody ApproveDocumentRequest approveDocumentRequest) {
        documentService.approveDocument(approveDocumentRequest);
        return BaseResponse.successfulResponse();    }

    @PostMapping("/getSignatureRequest")
    @ApiOperation(value = "Returns signature request for authenticated user", nickname = "getSignatureRequest")
    @FormKey(ProcessFormKey.SIGN_DOCUMENT)
    public SignfluentSignatureRequest getSignatureRequest(@RequestBody UserBasedRequest userBasedRequest) {
//        documentService.getSignDocumentsTasks(userBasedRequest);
        return new SignfluentSignatureRequest("123456", "signMe");
    }

    @PostMapping("/submitSignature")
    @ApiOperation(value = "Submits document signature", nickname = "submitSignature")
    @FormKey(ProcessFormKey.SIGN_DOCUMENT)
    public BaseResponse submitSignature(@RequestBody SignfluentSignature signfluentSignature) {
        // TODO: Handle the logic to process signature received from the device
        return BaseResponse.successfulResponse();    }
}
