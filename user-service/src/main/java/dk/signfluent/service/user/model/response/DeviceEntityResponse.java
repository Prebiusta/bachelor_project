package dk.signfluent.service.user.model.response;

import dk.signfluent.service.user.entity.DeviceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DeviceEntityResponse extends BaseResponse{
    private DeviceEntity deviceEntity;

    public DeviceEntityResponse(DeviceEntity deviceEntity) {
        this.deviceEntity = deviceEntity;
        this.setSuccessfulResponse();
    }
}
