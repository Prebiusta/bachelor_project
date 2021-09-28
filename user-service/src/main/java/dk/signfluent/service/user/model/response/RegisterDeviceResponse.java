package dk.signfluent.service.user.model.response;

import dk.signfluent.service.user.entity.DeviceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class RegisterDeviceResponse extends DeviceEntityResponse {
    public RegisterDeviceResponse(DeviceEntity deviceEntity) {
        super(deviceEntity);
    }
}
