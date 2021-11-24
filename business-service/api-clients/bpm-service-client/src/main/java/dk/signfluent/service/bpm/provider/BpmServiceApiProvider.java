package dk.signfluent.service.bpm.provider;

import dk.signfluent.bpm.service.invoker.ApiException;
import dk.signfluent.bpm.service.model.*;

import java.util.List;

public interface BpmServiceApiProvider {
    void uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws ApiException;

    BaseResponse inspectDocument(InspectDocumentRequest inspectDocumentRequest) throws ApiException;

    List<DocumentResponse> getDocumentsForInspection() throws ApiException;

    DocumentWithContent getDocumentDetails(ProcessIdRequest processIdRequest) throws ApiException;

    List<User> getActiveApprovers() throws ApiException;

    BaseResponse assignApprovers(AssignApproversRequest assignApproversRequest) throws ApiException;

    List<DocumentResponse> getDocumentsForApproval(UserBasedRequest userBasedRequest) throws ApiException;

    BaseResponse approveDocument(ApproveDocumentRequest approveDocumentRequest) throws ApiException;

    SignfluentSignatureRequest getSignatureRequest(UserBasedRequest userBasedRequest) throws ApiException;

    BaseResponse submitSignature(SignfluentSignature signfluentSignature) throws ApiException;
}
