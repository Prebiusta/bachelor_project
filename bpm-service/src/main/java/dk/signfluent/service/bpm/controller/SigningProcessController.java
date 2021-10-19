package dk.signfluent.service.bpm.controller;

import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.bpm.model.*;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.bpm.service.DocumentService;
import dk.signfluent.service.bpm.service.UserService;
import dk.signfluent.service.bpm.utility.FormKey;
import dk.signfluent.service.bpm.utility.ProcessFormKey;
import dk.signfluent.user.service.model.User;
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
    public void uploadDocument(@RequestBody UploadDocumentRequest uploadDocumentRequest) {
        documentService.uploadDocument(uploadDocumentRequest);
    }
//    @PostMapping("/getDocumentDetails")
//    public String documentsForDelegation(@RequestBody DocumentsDelegationRequest documentsDelegationRequest){
//        documentService.delegationDocuments(documentsDelegationRequest);
//        return "Done";
//    }

    @PostMapping("/inspectDocument")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public String inspectDocument(@RequestBody InspectDocumentRequest inspectDocumentRequest) {
        documentService.inspectDocument(inspectDocumentRequest);
        return "Done";
    }

    @PostMapping("/getDocumentsForInspection")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public List<DocumentResponse> getDocumentsForInspection() {
        return documentService.getDocumentsForInspection();
    }

    @PostMapping("/getDocumentDetails")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public DocumentWithContent getDocumentDetails(TaskIdRequest taskIdRequest) {
        return documentService.getDocumentDetails(taskIdRequest.getTaskId());
    }

    @PostMapping("/getActiveApprovers")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public List<User> getActiveApprovers() {
        return userService.getActiveApprovers();
    }

    @PostMapping("/test")
    @FormKey(ProcessFormKey.INSPECT_DOCUMENT)
    public List<User> test() {
        return userService.getActiveApprovers();
    }
}
