package dk.signfluent.service.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceBasedRequest extends UserBasedRequest {
    private String deviceId;
}
