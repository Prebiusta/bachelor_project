package dk.signfluent.service.device.model.response;

import dk.signfluent.service.device.entity.DeviceEntity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UpdateFCMTokenResponse extends DeviceEntityResponse {
    public UpdateFCMTokenResponse(DeviceEntity deviceEntity) {
        super(deviceEntity);
    }
}

