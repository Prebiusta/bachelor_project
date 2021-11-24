package dk.signfluent.service.bpm.provider;

import dk.signfluent.bpm.service.api.SigningProcessControllerApi;
import dk.signfluent.bpm.service.invoker.ApiException;
import dk.signfluent.bpm.service.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BpmServiceApiProviderImpl implements BpmServiceApiProvider {
    private final SigningProcessControllerApi signingProcessControllerApi;

    public BpmServiceApiProviderImpl(SigningProcessControllerApi signingProcessControllerApi) {
        this.signingProcessControllerApi = signingProcessControllerApi;
    }


    @Override
    public void uploadDocument(UploadDocumentRequest uploadDocumentRequest) throws ApiException {
        signingProcessControllerApi.uploadDocument(uploadDocumentRequest);
    }

    @Override
    public BaseResponse inspectDocument(InspectDocumentRequest inspectDocumentRequest) throws ApiException {
        return signingProcessControllerApi.inspectDocument(inspectDocumentRequest);
    }

    @Override
    public List<DocumentResponse> getDocumentsForInspection() throws ApiException {
        return signingProcessControllerApi.getDocumentsForInspection();
    }

    @Override
    public DocumentWithContent getDocumentDetails(ProcessIdRequest processIdRequest) throws ApiException {
        return signingProcessControllerApi.getDocumentDetails(processIdRequest);
    }

    @Override
    public List<User> getActiveApprovers() throws ApiException {
        return signingProcessControllerApi.getActiveApprovers();
    }

    @Override
    public BaseResponse assignApprovers(AssignApproversRequest assignApproversRequest) throws ApiException {
        return signingProcessControllerApi.assignApprovers(assignApproversRequest);
    }

    @Override
    public List<DocumentResponse> getDocumentsForApproval(UserBasedRequest userBasedRequest) throws ApiException {
        return signingProcessControllerApi.getDocumentsForApproval(userBasedRequest);
    }

    @Override
    public BaseResponse approveDocument(ApproveDocumentRequest approveDocumentRequest) throws ApiException {
        return signingProcessControllerApi.approveDocument(approveDocumentRequest);
    }

    @Override
    public SignfluentSignatureRequest getSignatureRequest(UserBasedRequest userBasedRequest) throws ApiException {
        return signingProcessControllerApi.getSignatureRequest(userBasedRequest);
    }

    @Override
    public BaseResponse submitSignature(SignfluentSignature signfluentSignature) throws ApiException {
        return signingProcessControllerApi.submitSignature(signfluentSignature);
    }
}
