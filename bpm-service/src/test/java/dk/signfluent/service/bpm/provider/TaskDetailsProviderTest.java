package dk.signfluent.service.bpm.provider;

import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.DocumentRow;
import dk.signfluent.service.bpm.mapper.DocumentMapper;
import dk.signfluent.service.bpm.model.Document;
import dk.signfluent.service.bpm.model.TaskDocumentModel;
import dk.signfluent.service.bpm.model.response.DocumentResponse;
import dk.signfluent.service.document.api.provider.DocumentServiceApiProvider;
import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.model.User;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskDetailsProviderTest {
    private final String TEST_DOCUMENT_ID = "9e9f8e10-2345-46ab-b2aa-a3813ca9dc52";
    private final String TEST_PROCESS_INSTANCE_ID = "58761cd8-8f97-44ac-a7b8-b1bb0098a94f";
    private final String TEST_UPLOADER_ID = "e31a6359-90c6-4c3e-875f-529ab42e6960";
    private final String TEST_DESCRIPTION = "description";
    private final OffsetDateTime TEST_UPLOADED_DATE = OffsetDateTime.now();
    private final DocumentRow.StatusEnum TEST_ROW_STATUS = DocumentRow.StatusEnum.FOR_APPROVAL;
    private final String TEST_USER_EMAIL = "TEST_USER_EMAIL";
    private final String TEST_USERNAME = "TEST_USERNAME";
    private final String TEST_FIRST_NAME = "TEST_FIRST_NAME";
    private final String TEST_LAST_NAME = "TEST_LAST_NAME";
    private final DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);
    private TaskDetailsProvider taskDetailsProvider;
    @Mock
    private UserServiceApiProvider userServiceApiProvider;
    @Mock
    private DocumentServiceApiProvider documentServiceApiProvider;

    @Before
    public void setUp() {
        this.taskDetailsProvider = new TaskDetailsProvider(userServiceApiProvider, documentServiceApiProvider, documentMapper);
    }

    @Test
    public void testAppendDocumentInformationToTaskNoTasks() throws Exception {
        returnEmptyListOfUsersWhenUserServiceIsCalled();
        returnEmptyListOfDocumentsWhenDocumentServiceIsCalled();

        List<DocumentResponse> documentResponses = taskDetailsProvider.appendDocumentsInformationToTask(createProcessInstanceList(0));

        assertEquals(0, documentResponses.size());
    }

    @Test
    public void testAppendDocumentInformationToTaskNoMatchingUser() throws Exception {
        returnEmptyListOfUsersWhenUserServiceIsCalled();
        returnListOfDocumentsWhenDocumentServiceIsCalled();

        List<DocumentResponse> documentResponses = taskDetailsProvider.appendDocumentsInformationToTask(createProcessInstanceList(1));

        assertNull(documentResponses.get(0).getDocument().getUploadedBy());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendDocumentInformationToTaskUploadedByNotPresent() throws Exception {
        returnEmptyListOfUsersWhenUserServiceIsCalled();
        returnListOfDocumentsWithNullUploaderWhenDocumentServiceIsCalled();

        taskDetailsProvider.appendDocumentsInformationToTask(createProcessInstanceList(1));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAppendDocumentInformationToTaskNoDocumentFoundForTask() throws Exception {
        returnListOfUsersWhenUserServiceIsCalled();
        returnEmptyListOfDocumentsWhenDocumentServiceIsCalled();

        taskDetailsProvider.appendDocumentsInformationToTask(createProcessInstanceList(1));
    }


    @Test
    public void testAppendDocumentInformationToTask() throws Exception {
        returnListOfUsersWhenUserServiceIsCalled();
        returnListOfDocumentsWhenDocumentServiceIsCalled();

        List<DocumentResponse> documentResponses = taskDetailsProvider.appendDocumentsInformationToTask(createProcessInstanceList(1));

        verifyDocumentResponseAttributes(documentResponses.get(0));
        verifyMappedUserAttributes(documentResponses.get(0).getDocument().getUploadedBy());
    }

    private void verifyMappedUserAttributes(User uploadedBy) {
        assertEquals(TEST_UPLOADER_ID, uploadedBy.getId());
        assertEquals(TEST_USER_EMAIL, uploadedBy.getEmail());
        assertEquals(TEST_USERNAME, uploadedBy.getUsername());
        assertEquals(TEST_LAST_NAME, uploadedBy.getLastName());
        assertEquals(TEST_FIRST_NAME, uploadedBy.getFirstName());
    }

    private void verifyDocumentResponseAttributes(DocumentResponse documentResponse) {
        assertEquals(TEST_PROCESS_INSTANCE_ID, documentResponse.getProcessId());

        Document documentFromResponse = documentResponse.getDocument();
        assertEquals(TEST_DESCRIPTION, documentFromResponse.getDescription());
        assertEquals(TEST_ROW_STATUS.getValue(), documentFromResponse.getStatus());
        assertEquals(TEST_UPLOADED_DATE, documentFromResponse.getUploadedAt());
    }

    private void returnListOfDocumentsWithNullUploaderWhenDocumentServiceIsCalled() throws ApiException {
        when(documentServiceApiProvider.getDocumentList(any())).thenReturn(List.of(createTestDocumentRow(null)));
    }

    private void returnListOfDocumentsWhenDocumentServiceIsCalled() throws ApiException {
        when(documentServiceApiProvider.getDocumentList(any())).thenReturn(List.of(createTestDocumentRow(UUID.fromString(TEST_UPLOADER_ID))));
    }

    private void returnEmptyListOfDocumentsWhenDocumentServiceIsCalled() throws ApiException {
        when(documentServiceApiProvider.getDocumentList(any())).thenReturn(Collections.emptyList());
    }

    private void returnListOfUsersWhenUserServiceIsCalled() throws dk.signfluent.user.service.invoker.ApiException {
        when(userServiceApiProvider.getUsersByIds(any())).thenReturn(List.of(createTestUser()));
    }

    private void returnEmptyListOfUsersWhenUserServiceIsCalled() throws dk.signfluent.user.service.invoker.ApiException {
        when(userServiceApiProvider.getUsersByIds(any())).thenReturn(Collections.emptyList());
    }

    private List<ProcessInstance> createProcessInstanceList(int amount) {
        List<ProcessInstance> taskDocumentModelList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            taskDocumentModelList.add(createTestProcessInstance());
        }
        return taskDocumentModelList;
    }

    private ProcessInstance createTestProcessInstance() {
        ExecutionEntity executionEntity = new ExecutionEntity();
        executionEntity.setProcessInstanceId(TEST_PROCESS_INSTANCE_ID);
        executionEntity.setBusinessKey(TEST_DOCUMENT_ID);
        return executionEntity;
    }

    private DocumentRow createTestDocumentRow(UUID uploaderId) {
        DocumentRow documentRow = new DocumentRow();
        documentRow.setDocumentId(UUID.fromString(TEST_DOCUMENT_ID));
        documentRow.setDescription(TEST_DESCRIPTION);
        documentRow.setStatus(TEST_ROW_STATUS);
        documentRow.setUploadDate(TEST_UPLOADED_DATE);
        documentRow.setUploaderId(uploaderId);
        return documentRow;
    }

    private User createTestUser() {
        User user = new User();
        user.setId(TEST_UPLOADER_ID);
        user.setEmail(TEST_USER_EMAIL);
        user.setFirstName(TEST_FIRST_NAME);
        user.setLastName(TEST_LAST_NAME);
        user.setUsername(TEST_USERNAME);
        return user;
    }

}