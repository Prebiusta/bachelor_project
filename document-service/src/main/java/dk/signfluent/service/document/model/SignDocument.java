package dk.signfluent.service.document.model;

import lombok.Data;

import java.util.UUID;

@Data
public class SignDocument {
    UUID documentId;
    Signature signature;
}
