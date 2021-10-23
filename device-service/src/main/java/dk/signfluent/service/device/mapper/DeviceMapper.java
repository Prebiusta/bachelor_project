package dk.signfluent.service.device.mapper;

import dk.signfluent.service.device.entity.DeviceEntity;
import dk.signfluent.service.device.model.Device;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DeviceMapper {
    Device mapDeviceEntityToModel(DeviceEntity deviceEntity);
}
