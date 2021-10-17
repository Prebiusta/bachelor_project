package dk.signfluent.certificateauthority.validation.controller;

import dk.signfluent.certificateauthority.validation.mappers.SignatureRequestMapper;
import dk.signfluent.certificateauthority.validation.network.SignatureValidationRequest;
import dk.signfluent.certificateauthority.validation.services.ValidationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/validation")
public class ValidationController {
    private final ValidationService validationService;
    private final SignatureRequestMapper mapper;

    public ValidationController(ValidationService validationService, SignatureRequestMapper mapper) {
        this.validationService = validationService;
        this.mapper = mapper;
    }

    @PostMapping("/signature")
    public boolean validateSignature(@RequestBody SignatureValidationRequest signatureValidationRequest) {
        return validationService.validateSignature(mapper.mapSignatureRequest(signatureValidationRequest));
    }
}
