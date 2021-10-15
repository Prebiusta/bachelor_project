package dk.signfluent.service.document.entity;

import com.sun.istack.NotNull;
import dk.signfluent.service.document.utils.Enums.DocumentStatus;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;
    @NotNull
    private byte[] content;
    @NotNull
    private byte[] hash;
    @NotNull
    private DocumentStatus status;

    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<ApprovalOrder> approvalOrder;

    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Signature> signatures;

    @OneToOne(cascade = {CascadeType.ALL})
    private Delegator delegator;

    @OneToOne(cascade = {CascadeType.ALL})
    private Rejector rejector;

    @OneToOne(cascade = {CascadeType.ALL})
    private Uploader uploader;

    public Document(UUID uploaderId, String description, byte[] content, byte[] hash, DocumentStatus status){
        this.description = description;
        this.uploader = new Uploader(uploaderId, new Date());
        this.content = content;
        this.hash = hash;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Document document = (Document) o;
        return id != null && Objects.equals(id, document.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
