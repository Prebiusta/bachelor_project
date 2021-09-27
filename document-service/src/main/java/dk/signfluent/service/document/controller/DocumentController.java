package dk.signfluent.service.document.controller;

import dk.signfluent.service.document.model.DocumentReturnModel;
import dk.signfluent.service.document.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/getDocument")
    public DocumentReturnModel getDocument(@RequestParam(value = "id") UUID id) {
        return documentService.getDocumentById(id);
    }
}