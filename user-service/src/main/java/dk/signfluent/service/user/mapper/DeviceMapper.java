package dk.signfluent.service.user.mapper;

import dk.signfluent.service.user.entity.DeviceEntity;
import dk.signfluent.service.user.model.Device;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DeviceMapper {
    Device mapDeviceEntityToModel(DeviceEntity deviceEntity);
}
