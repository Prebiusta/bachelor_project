package dk.signfluent.service.user.model.response;

import dk.signfluent.service.user.entity.DeviceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UpdateFCMTokenResponse extends DeviceEntityResponse {
    public UpdateFCMTokenResponse(DeviceEntity deviceEntity) {
        super(deviceEntity);
    }
}

