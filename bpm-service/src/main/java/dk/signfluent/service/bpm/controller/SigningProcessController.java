package dk.signfluent.service.bpm.controller;

import dk.signfluent.service.bpm.model.DocumentWithContent;
import dk.signfluent.service.bpm.model.InspectDocumentRequest;
import dk.signfluent.service.bpm.model.TaskIdRequest;
import dk.signfluent.service.bpm.model.UploadDocumentRequest;
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
    public void uploadDocument(@RequestBody UploadDocumentRequest uploadDocumentRequest) {
        documentService.uploadDocument(uploadDocumentRequest);
    }
//    @PostMapping("/getDocumentDetails")
//    public String documentsForDelegation(@RequestBody DocumentsDelegationRequest documentsDelegationRequest){
//        documentService.delegationDocuments(documentsDelegationRequest);
//        return "Done";
//    }

    @PostMapping("/inspectDocument")
    @ApiOperation(value = "Inspect document and assign approvers", nickname = "inspectDocument")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public String inspectDocument(@RequestBody InspectDocumentRequest inspectDocumentRequest) {
        documentService.inspectDocument(inspectDocumentRequest);
        return "Done";
    }

    @PostMapping("/getDocumentsForInspection")
    @ApiOperation(value = "Returns documents needed inspection", nickname = "getDocumentsForInspection")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public List<DocumentResponse> getDocumentsForInspection() {
        return documentService.getDocumentsForInspection();
    }

    @PostMapping("/getDocumentDetails")
    @ApiOperation(value = "Returns document details for specified task", nickname = "getDocumentDetails")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public DocumentWithContent getDocumentDetails(@RequestBody TaskIdRequest taskIdRequest) {
        return documentService.getDocumentDetails(taskIdRequest.getTaskId());
    }

    @PostMapping("/getActiveApprovers")
    @ApiOperation(value = "Get active approvers", nickname = "getActiveApprovers")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public List<User> getActiveApprovers() {
        return userService.getActiveApprovers();
    }
}
