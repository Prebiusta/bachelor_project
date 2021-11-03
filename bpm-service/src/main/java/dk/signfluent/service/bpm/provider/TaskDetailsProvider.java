package dk.signfluent.service.bpm.provider;

import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.bpm.mapper.DocumentMapper;
import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.TaskDocumentModel;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.model.User;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TaskDetailsProvider {
    private final UserServiceApiProvider userServiceApiProvider;
    private final DocumentServiceApiProvider documentServiceApiProvider;
    private final DocumentMapper documentMapper;

    public TaskDetailsProvider(UserServiceApiProvider userServiceApiProvider, DocumentServiceApiProvider documentServiceApiProvider, DocumentMapper documentMapper) {
        this.userServiceApiProvider = userServiceApiProvider;
        this.documentServiceApiProvider = documentServiceApiProvider;
        this.documentMapper = documentMapper;
    }

    public List<DocumentResponse> appendDocumentsInformationToTask(List<ProcessInstance> processInstanceList) throws Exception {
        List<DocumentRow> documentRowList = documentServiceApiProvider.getDocumentList(extractDocumentIdsFromTaskDocumentModel(processInstanceList));

        Map<String, DocumentRow> documentIdToDocumentRowMap = getDocumentIdToDocumentRowMap(documentRowList);
        Map<String, User> userIdToUserMap = getUserIdToUserMap(extractUserIdsFromDocumentRowList(documentRowList));

        return processInstanceList.stream()
                .map(mapTaskDocumentModelToDocumentWithUserData(documentIdToDocumentRowMap, userIdToUserMap))
                .collect(Collectors.toList());
    }

    @NotNull
    private Function<ProcessInstance, DocumentResponse> mapTaskDocumentModelToDocumentWithUserData(Map<String, DocumentRow> documentIdToDocumentRowMap, Map<String, User> userIdToUserMap) {
        return processInstance -> {
            String documentId = extractDocumentIdFromProcessInstance(processInstance);

            DocumentRow matchingDocumentRow = documentIdToDocumentRowMap.get(documentId);
            Assert.notNull(matchingDocumentRow, "Document with ID " + documentId + " was not found" );
            Assert.notNull(matchingDocumentRow.getUploaderId(), "Uploader ID is not present");

            Document document = documentMapper.mapDocumentRowToDocument(matchingDocumentRow);
            document.setUploadedBy(userIdToUserMap.get(matchingDocumentRow.getUploaderId().toString()));

            DocumentResponse documentResponse = new DocumentResponse();
            documentResponse.setProcessId(processInstance.getProcessInstanceId());
            documentResponse.setDocument(document);
            return documentResponse;
        };
    }

    @NotNull
    private List<String> extractUserIdsFromDocumentRowList(List<DocumentRow> documentRowList) {
        return documentRowList.stream().map(DocumentRow::getUploaderId).filter(Objects::nonNull).map(UUID::toString).collect(Collectors.toList());
    }

    @NotNull
    private List<String> extractDocumentIdsFromTaskDocumentModel(List<ProcessInstance> processInstanceList) {
        return processInstanceList.stream().map(this::extractDocumentIdFromProcessInstance).collect(Collectors.toList());
    }

    private String extractDocumentIdFromProcessInstance(ProcessInstance processInstance) {
        return processInstance.getBusinessKey();
    }

    private Map<String, DocumentRow> getDocumentIdToDocumentRowMap(List<DocumentRow> documentRowList) {
        return documentRowList.stream().collect(Collectors.toMap(a -> Objects.requireNonNull(a.getDocumentId()).toString(), a -> a));
    }

    private Map<String, User> getUserIdToUserMap(List<String> userIds) throws Exception {
        List<User> userList = userServiceApiProvider.getUsersByIds(userIds);
        return userList.stream().collect(Collectors.toMap(User::getId, a -> a));
    }
}