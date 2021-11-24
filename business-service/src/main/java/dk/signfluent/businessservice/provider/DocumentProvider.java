package dk.signfluent.businessservice.provider;

import dk.signfluent.businessservice.mapper.DocumentMapper;
import dk.signfluent.businessservice.model.response.DocumentDetailsResponse;
import dk.signfluent.businessservice.model.response.DocumentResponse;
import dk.signfluent.businessservice.model.response.DocumentWithProcessResponse;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DocumentProvider {
    private final UserServiceApiProvider userServiceApiProvider;
    private final DocumentServiceApiProvider documentServiceApiProvider;
    private final DocumentMapper documentMapper;

    public DocumentProvider(UserServiceApiProvider userServiceApiProvider, DocumentServiceApiProvider documentServiceApiProvider, DocumentMapper documentMapper) {
        this.userServiceApiProvider = userServiceApiProvider;
        this.documentServiceApiProvider = documentServiceApiProvider;
        this.documentMapper = documentMapper;
    }

    public List<DocumentResponse> convertDocumentRowsToDocuments(List<DocumentRow> documentRowList) throws Exception {
        Map<String, User> userIdToUserMap = getUserIdToUserMap(extractUserIdsFromDocumentRowList(documentRowList));
        return documentRowList
                .stream()
                .map(documentRow -> mapDocumentRowToDocument(documentRow, userIdToUserMap))
                .collect(Collectors.toList());
    }

    public List<DocumentWithProcessResponse> appendDocumentData(List<dk.signfluent.bpm.service.model.DocumentResponse> documentResponseList) throws Exception {
        List<String> documentIds = documentResponseList.stream().map(dk.signfluent.bpm.service.model.DocumentResponse::getDocumentId).collect(Collectors.toList());
        List<DocumentRow> documentRowList = documentServiceApiProvider.getDocumentList(documentIds);

        Map<String, DocumentRow> documentIdToDocumentRowMap = getDocumentIdToDocumentRowMap(documentRowList);
        Map<String, User> userIdToUserMap = getUserIdToUserMap(extractUserIdsFromDocumentRowList(documentRowList));

        return documentResponseList.stream()
                .map(mapTaskDocumentModelToDocumentWithUserData(documentIdToDocumentRowMap, userIdToUserMap))
                .collect(Collectors.toList());
    }

    private Function<dk.signfluent.bpm.service.model.DocumentResponse, DocumentWithProcessResponse> mapTaskDocumentModelToDocumentWithUserData(Map<String, DocumentRow> documentIdToDocumentRowMap, Map<String, User> userIdToUserMap) {
        return documentResponse -> {
            String documentId = documentResponse.getDocumentId();
            DocumentResponse document = mapDocumentRowToDocument(documentIdToDocumentRowMap.get(documentId), userIdToUserMap);

            DocumentWithProcessResponse documentWithProcessResponse = new DocumentWithProcessResponse();
            documentWithProcessResponse.setProcessId(documentResponse.getProcessId());
            documentWithProcessResponse.setDocument(document);
            return documentWithProcessResponse;
        };
    }

    private DocumentResponse mapDocumentRowToDocument(DocumentRow documentRow, Map<String, User> userIdToUserMap) {
        Assert.notNull(documentRow.getUploaderId(), "Uploader ID is not present");

        DocumentResponse document = documentMapper.mapDocumentRowToDocument(documentRow);
        document.setUploadedBy(userIdToUserMap.get(documentRow.getUploaderId().toString()));
        return document;
    }

    private List<String> extractUserIdsFromDocumentRowList(List<DocumentRow> documentRowList) {
        return documentRowList.stream().map(DocumentRow::getUploaderId).filter(Objects::nonNull).map(UUID::toString).collect(Collectors.toList());
    }

    private Map<String, DocumentRow> getDocumentIdToDocumentRowMap(List<DocumentRow> documentRowList) {
        return documentRowList.stream().collect(Collectors.toMap(a -> Objects.requireNonNull(a.getDocumentId()).toString(), a -> a));
    }

    private Map<String, User> getUserIdToUserMap(List<String> userIds) throws Exception {
        List<User> userList = userServiceApiProvider.getUsersByIds(userIds);
        return userList.stream().collect(Collectors.toMap(User::getId, a -> a));
    }
}
