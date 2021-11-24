package dk.signfluent.businessservice.controller.api;

import dk.signfluent.businessservice.model.response.DocumentDetailsResponse;
import dk.signfluent.businessservice.model.response.DocumentResponse;
import dk.signfluent.businessservice.provider.DocumentProvider;
import dk.signfluent.businessservice.service.DocumentService;
import dk.signfluent.document.service.invoker.ApiException;
import dk.signfluent.document.service.model.Document;
import dk.signfluent.document.service.model.DocumentRow;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dk.signfluent.businessservice.utility.AuthorizationTypes.ADMINISTRATOR;
import static dk.signfluent.businessservice.utility.AuthorizationTypes.AUTHENTICATED;

@RestController
@RequestMapping("/api/document")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/getAll")
    @ApiOperation(value = "Returns all available documents", nickname = "getAllDocuments")
    @PreAuthorize(ADMINISTRATOR)
    public List<DocumentResponse> getAllDocuments() throws Exception {
        return documentService.getAllDocuments();
    }

    @PostMapping("/get/{documentId}")
    @ApiOperation(value = "Returns details for selected documents", nickname = "getDocumentDetails")
    @PreAuthorize(ADMINISTRATOR)
    public DocumentDetailsResponse getDocumentDetails(@PathVariable String documentId) throws ApiException {
        return documentService.getDocumentDetails(documentId);
    }

    @PostMapping("/getOwn")
    @ApiOperation(value = "Returns documents own by authenticated user", nickname = "getOwnDocuments")
    @PreAuthorize(AUTHENTICATED)
    public List<DocumentResponse> getOwnDocuments() throws Exception {
        return documentService.getAllDocumentsForApprover();
    }
}
