package dk.signfluent.service.user.entity;

import lombok.*;

import javax.persistence.Entity;

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
}
