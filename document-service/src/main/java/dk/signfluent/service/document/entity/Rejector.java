package dk.signfluent.service.document.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

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
public class Rejector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    private UUID rejectorId;

    private Date rejectDate;

    public Rejector(UUID rejectorId, Date rejectDate) {
        this.rejectorId = rejectorId;
        this.rejectDate = rejectDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rejector rejector = (Rejector) o;
        return id != null && Objects.equals(id, rejector.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
