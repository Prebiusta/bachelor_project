package dk.signfluent.service.device.model.response;

import dk.signfluent.service.device.entity.DeviceEntity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class RegisterDeviceResponse extends DeviceEntityResponse {
    public RegisterDeviceResponse(DeviceEntity deviceEntity) {
        super(deviceEntity);
    }
}
