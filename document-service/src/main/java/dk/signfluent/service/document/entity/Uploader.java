package dk.signfluent.service.document.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Uploader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID uploaderId;

    private Date uploadDate;

    public Uploader(UUID uploaderId, Date uploadDate)
    {
        this.uploaderId = uploaderId;
        this.uploadDate = uploadDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Uploader uploader = (Uploader) o;
        return id != null && Objects.equals(id, uploader.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}