package dk.signfluent.service.document.controller;

import dk.signfluent.service.document.model.*;
import dk.signfluent.service.document.service.DocumentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/uploadDocument")
    @ApiOperation(value = "Upload a document", nickname = "uploadDocument")
    public UUID uploadDocument(@RequestBody UploadDocument document ) {
        return documentService.uploadDocument(document);
    }

    @GetMapping("/getDocumentList")
    @ApiOperation(value = "Get Document list with base data", nickname = "getDocumentList")
    public List<DocumentRow> getDocumentList(@RequestBody List<UUID> documentIds) throws Exception {
        return documentService.getDocumentList(documentIds);
    }

    @GetMapping("/getDocumentContent")
    @ApiOperation(value = "Get Document detailed content", nickname = "getDocumentContent")
    public DocumentContent getDocumentContent(@RequestParam UUID documentId) throws Exception {
        return documentService.getDocumentContent(documentId);
    }

    @PostMapping("/rejectDocument")
    @ApiOperation(value = "Reject document signing", nickname = "rejectDocument")
    public UUID rejectDocument(@RequestParam UUID documentId, @RequestParam UUID rejectorId) throws Exception {
        return documentService.rejectDocument(documentId, rejectorId);
    }

    @PostMapping("/assignApprovers")
    @ApiOperation(value = "Assign approvers in designated order", nickname = "assignApprovers")
    public UUID assignApprovers(@RequestBody AssignApprovers assignApprovers) throws Exception {
        return documentService.assignApprovers(assignApprovers);
    }

    @PostMapping("/signDocument")
    @ApiOperation(value = "Sign document", nickname = "signDocument")
    public UUID signDocument(@RequestBody SignDocument document ) throws Exception {
        return documentService.signDocument(document);
    }
}