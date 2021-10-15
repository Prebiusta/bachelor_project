package dk.signfluent.service.document.model;

import lombok.Data;

@Data
public class Signature {
    String x509Pem;
    String signedContent;
}
