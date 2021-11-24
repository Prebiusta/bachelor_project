package dk.signfluent.service.device.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "device")
@AllArgsConstructor
@NoArgsConstructor
public class DeviceEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Type(type = "uuid-char")
    private UUID userId;

    private String deviceHardwareId;

    private String FCMToken;

}
