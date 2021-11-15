package dk.signfluent.service.bpm.provider;

import dk.signfluent.bpm.service.invoker.ApiException;
import dk.signfluent.bpm.service.model.*;

import java.util.List;

public interface BpmServiceApiProvider {
    void uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws ApiException;

    String inspectDocument(InspectDocumentRequest inspectDocumentRequest) throws ApiException;

    List<DocumentResponse> getDocumentsForInspection() throws ApiException;

    DocumentWithContent getDocumentDetails(ProcessIdRequest processIdRequest) throws ApiException;

    List<User> getActiveApprovers() throws ApiException;

    String assignApprovers(AssignApproversRequest assignApproversRequest) throws ApiException;

    List<DocumentResponse> getDocumentsForApproval(UserBasedRequest userBasedRequest) throws ApiException;

    String approveDocument(ApproveDocumentRequest approveDocumentRequest) throws ApiException;

    SignfluentSignatureRequest getSignatureRequest(UserBasedRequest userBasedRequest) throws ApiException;

    String submitSignature(SignfluentSignature signfluentSignature) throws ApiException;
}
