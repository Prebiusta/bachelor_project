package dk.signfluent.service.document.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String content;
    @ElementCollection
    private List<String> signatures;

    public DocumentEntity(String content, List<String> signatures) {
        this.content = content;
        this.signatures = signatures;
    }
}
