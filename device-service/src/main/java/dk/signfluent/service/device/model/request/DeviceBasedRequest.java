package dk.signfluent.service.device.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceBasedRequest extends UserBasedRequest {
    private String deviceHardwareId;
}
