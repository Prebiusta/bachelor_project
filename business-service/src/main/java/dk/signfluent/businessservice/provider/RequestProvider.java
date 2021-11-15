package dk.signfluent.businessservice.provider;

import dk.signfluent.bpm.service.model.*;
import org.springframework.stereotype.Service;

@Service
public class RequestProvider {
    private final UserProvider userProvider;

    public RequestProvider(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public UploadDocumentRequest appendAuthenticatedUserIdToRequest(UploadDocumentRequest uploadDocumentRequest) {
        uploadDocumentRequest.setUserId(userProvider.getCurrentUserId());
        return uploadDocumentRequest;
    }

    public InspectDocumentRequest appendApproverIdToInspectDocumentRequest(InspectDocumentRequest inspectDocumentRequest) {
        inspectDocumentRequest.setDelegatorId(userProvider.getCurrentUserId());
        return inspectDocumentRequest;
    }

    public AssignApproversRequest appendDelegatorIdToAssignApproversRequest(AssignApproversRequest assignApproversRequest) {
        assignApproversRequest.setDelegatorId(userProvider.getCurrentUserId());
        return assignApproversRequest;
    }

    public UserBasedRequest generateUserBasedRequest() {
        UserBasedRequest userBasedRequest = new UserBasedRequest();
        userBasedRequest.setUserId(userProvider.getCurrentUserId());
        return userBasedRequest;
    }

    public ApproveDocumentRequest appendApproverIdToApproveDocumentRequest(ApproveDocumentRequest approveDocumentRequest) {
        approveDocumentRequest.setApproverId(userProvider.getCurrentUserId());
        return approveDocumentRequest;
    }

    public SignfluentSignature appendApproverIdToSignfluentSignature(SignfluentSignature signfluentSignature) {
        signfluentSignature.setApproverId(userProvider.getCurrentUserId());
        return signfluentSignature;
    }
}
