package dk.signfluent.service.user.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends EntityBase {
    private String name;
    private String email;
    @ToString.Exclude
    private String password;

    @OneToMany(mappedBy = "user")
    private List<DeviceEntity> deviceEntities;
}
