package dk.signfluent.service.bpm.controller;

import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.InspectDocumentRequest;
import dk.signfluent.service.bpm.model.TaskIdRequest;
import dk.signfluent.service.bpm.model.UploadDocumentRequest;
import dk.signfluent.service.bpm.service.DocumentService;
import dk.signfluent.service.bpm.service.UserService;
import dk.signfluent.user.service.model.User;
import org.camunda.bpm.engine.TaskService;
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
    private final TaskService taskService;


    public SigningProcessController(DocumentService documentService, UserService userService, TaskService taskService) {
        this.documentService = documentService;
        this.userService = userService;
        this.taskService = taskService;
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
    public String inspectDocument(@RequestBody InspectDocumentRequest inspectDocumentRequest){
        documentService.inspectDocument(inspectDocumentRequest);
        return "Done";
    }

    @PostMapping("/getDocumentsForInspection")
    public List<Document> getDocumentsForInspection(){
        return documentService.getDocumentsForInspection();
    }

    @PostMapping("/getDocumentDetails")
    public Document getDocumentDetails(TaskIdRequest taskIdRequest){
        return documentService.getDocumentDetails(taskIdRequest.getTaskId());
    }

    // TODO: Get approvers
    @PostMapping("/getActiveApprovers")
    public List<User> getActiveApprovers(){
        return userService.getActiveApprovers();
    }
}
