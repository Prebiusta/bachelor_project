package dk.signfluent.businessservice.controller.bpm;

import dk.signfluent.bpm.service.invoker.ApiException;
import dk.signfluent.bpm.service.model.*;
import dk.signfluent.businessservice.model.response.DocumentWithProcessResponse;
import dk.signfluent.businessservice.provider.DocumentProvider;
import dk.signfluent.businessservice.provider.RequestProvider;
import dk.signfluent.service.bpm.provider.BpmServiceApiProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dk.signfluent.businessservice.utility.AuthorizationTypes.*;

@RestController()
@RequestMapping("/api/signingProcess")
public class SigningProcessController {
    private final BpmServiceApiProvider bpmServiceApiProvider;
    private final RequestProvider requestProvider;
    private final DocumentProvider documentProvider;

    public SigningProcessController(BpmServiceApiProvider bpmServiceApiProvider, RequestProvider requestProvider, DocumentProvider documentProvider) {
        this.bpmServiceApiProvider = bpmServiceApiProvider;
        this.requestProvider = requestProvider;
        this.documentProvider = documentProvider;
    }

    @PostMapping(value = "/uploadDocument")
    @ApiOperation(value = "Uploads a document", nickname = "uploadDocument")
    @PreAuthorize(AUTHENTICATED)
    public void uploadDocument(@RequestBody UploadDocumentRequest uploadDocumentRequest) throws ApiException {
        bpmServiceApiProvider.uploadDocument(requestProvider.appendAuthenticatedUserIdToRequest(uploadDocumentRequest));
    }

    @PostMapping("/inspectDocument")
    @ApiOperation(value = "Inspect document and assign approvers", nickname = "inspectDocument")
    @PreAuthorize(DELEGATOR)
    public BaseResponse inspectDocument(@RequestBody InspectDocumentRequest inspectDocumentRequest) throws ApiException {
        return bpmServiceApiProvider.inspectDocument(requestProvider.appendApproverIdToInspectDocumentRequest(inspectDocumentRequest));
    }

    @PostMapping("/getDocumentsForInspection")
    @ApiOperation(value = "Returns documents needed inspection", nickname = "getDocumentsForInspection")
    @PreAuthorize(DELEGATOR)
    public List<DocumentWithProcessResponse> getDocumentsForInspection() throws Exception {
        List<DocumentResponse> documentsForInspection = bpmServiceApiProvider.getDocumentsForInspection();
        return documentProvider.appendDocumentData(documentsForInspection);
    }

    @PostMapping("/getDocumentDetails")
    @ApiOperation(value = "Returns document details for specified task", nickname = "getDocumentDetails")
    @PreAuthorize(DELEGATOR_OR_APPROVER)
    public DocumentWithContent getDocumentDetails(@RequestBody ProcessIdRequest processIdRequest) throws ApiException {
        return bpmServiceApiProvider.getDocumentDetails(processIdRequest);
    }

    @PostMapping("/getActiveApprovers")
    @ApiOperation(value = "Get active approvers", nickname = "getActiveApprovers")
    @PreAuthorize(DELEGATOR)
    public List<User> getActiveApprovers() throws ApiException {
        return bpmServiceApiProvider.getActiveApprovers();
    }

    @PostMapping("/assignApprovers")
    @ApiOperation(value = "Assign approvers to a document", nickname = "assignApprovers")
    @PreAuthorize(DELEGATOR)
    public BaseResponse assignApprovers(@RequestBody AssignApproversRequest assignApproversRequest) throws ApiException {
        return bpmServiceApiProvider.assignApprovers(requestProvider.appendDelegatorIdToAssignApproversRequest(assignApproversRequest));
    }

    @PostMapping("/getDocumentsForApproval")
    @ApiOperation(value = "Returns documents needed User's approval", nickname = "getDocumentsForApproval")
    @PreAuthorize(APPROVER)
    public List<DocumentWithProcessResponse> getDocumentsForApproval() throws Exception {
        List<DocumentResponse> documentsForApproval = bpmServiceApiProvider.getDocumentsForApproval(requestProvider.generateUserBasedRequest());
        return documentProvider.appendDocumentData(documentsForApproval);
    }

    @PostMapping("/approveDocument")
    @ApiOperation(value = "Submit approve document decision", nickname = "approveDocument")
    @PreAuthorize(APPROVER)
    public BaseResponse approveDocument(@RequestBody ApproveDocumentRequest approveDocumentRequest) throws ApiException {
        return bpmServiceApiProvider.approveDocument(requestProvider.appendApproverIdToApproveDocumentRequest(approveDocumentRequest));
    }

    @PostMapping("/getSignatureRequest")
    @ApiOperation(value = "Returns signature request for authenticated user", nickname = "getSignatureRequest")
    @PreAuthorize(APPROVER)
    public SignfluentSignatureRequest getSignatureRequest() throws ApiException {
        return bpmServiceApiProvider.getSignatureRequest(requestProvider.generateUserBasedRequest());
    }

    @PostMapping("/submitSignature")
    @ApiOperation(value = "Submits document signature", nickname = "submitSignature")
    @PreAuthorize(APPROVER)
    public BaseResponse submitSignature(@RequestBody SignfluentSignature signfluentSignature) throws ApiException {
        return bpmServiceApiProvider.submitSignature(requestProvider.appendApproverIdToSignfluentSignature(signfluentSignature));
    }
}
