package dk.signfluent.businessservice.controller.api;

import dk.signfluent.businessservice.provider.DocumentProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void getAllDocuments() {

    }

    @PostMapping("/get/{documentId}")
    @ApiOperation(value = "Returns details for selected documents", nickname = "getDocumentDetails")
    @PreAuthorize(ADMINISTRATOR)
    public void getDocumentDetails(@PathVariable String documentId) {

    }

    @PostMapping("/getOwn")
    @ApiOperation(value = "Returns documents own by authenticated user", nickname = "getOwnDocuments")
    @PreAuthorize(AUTHENTICATED)
    public void getOwnDocuments() {

    }
}
