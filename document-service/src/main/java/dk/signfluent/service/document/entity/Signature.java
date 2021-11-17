package dk.signfluent.service.document.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    private UUID id;
    private String certificate;
    private String signedHash;
    private Date signatureDate;

    public Signature(String certificate, String signedHash, Date signatureDate)
    {
        this.certificate = certificate;
        this.signedHash = signedHash;
        this.signatureDate = signatureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Signature signature = (Signature) o;
        return id != null && Objects.equals(id, signature.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
