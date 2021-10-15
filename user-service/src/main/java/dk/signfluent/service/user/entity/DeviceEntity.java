package dk.signfluent.service.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "device")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class DeviceEntity extends EntityBase {
    private String deviceId;
    private String FCMToken;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    @ToString.Exclude
    private UserEntity user;
}
