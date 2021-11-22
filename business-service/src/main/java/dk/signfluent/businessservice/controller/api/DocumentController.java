package dk.signfluent.businessservice.controller.api;

import dk.signfluent.businessservice.provider.DocumentProvider;
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
    private final DocumentProvider documentProvider;

    public DocumentController(DocumentProvider documentProvider) {
        this.documentProvider = documentProvider;
    }

    @PostMapping("/getAll")
    @ApiOperation(value = "Returns all available documents", nickname = "getAllDocuments")
    @PreAuthorize(ADMINISTRATOR)
    public List<DocumentRow> getAllDocuments() throws ApiException {
        return documentProvider.getAllDocuments();
    }

    @PostMapping("/get/{documentId}")
    @ApiOperation(value = "Returns details for selected documents", nickname = "getDocumentDetails")
    @PreAuthorize(ADMINISTRATOR)
    public Document getDocumentDetails(@PathVariable String documentId) throws ApiException {
        return documentProvider.getDocumentDetails(documentId);
    }

    @PostMapping("/getOwn")
    @ApiOperation(value = "Returns documents own by authenticated user", nickname = "getOwnDocuments")
    @PreAuthorize(AUTHENTICATED)
    public List<DocumentRow> getOwnDocuments() throws ApiException {
        return documentProvider.getAllDocumentsForApprover();
    }
}
