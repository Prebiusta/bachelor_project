package dk.signfluent.service.bpm.delegate;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.ApprovalOrderModel;
import dk.signfluent.document.service.model.AssignApprovers;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static dk.signfluent.service.bpm.utility.ProcessVariables.*;

@Component
public class AssignApproversDelegate implements JavaDelegate {
    private final DocumentServiceApiProvider documentServiceApiProvider;

    public AssignApproversDelegate(DocumentServiceApiProvider documentServiceApiProvider) {
        this.documentServiceApiProvider = documentServiceApiProvider;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        assignApprovers(delegateExecution);
    }

    public void assignApprovers(DelegateExecution delegateExecution) throws ApiException {
        documentServiceApiProvider.assignApprovers(generateAssignApproversApiRequest(
                (List<ApprovalOrderModel>) delegateExecution.getVariable(APPROVERS),
                (String) delegateExecution.getVariable(DOCUMENT_ID),
                (String) delegateExecution.getVariable(DELEGATOR_ID)
        ));
    }

    private AssignApprovers generateAssignApproversApiRequest(List<ApprovalOrderModel> approvers, String documentId, String delegatorId) {
        AssignApprovers assignApprovers = new AssignApprovers();
        assignApprovers.setApprovers(approvers);
        assignApprovers.setDocumentId(UUID.fromString(documentId));
        assignApprovers.setDelegatorId(UUID.fromString(delegatorId));
        return assignApprovers;
    }
}
