package dk.signfluent.service.device.mapper;

import dk.signfluent.service.device.entity.DeviceEntity;
import dk.signfluent.service.device.model.Device;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-23T00:50:00+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public Device mapDeviceEntityToModel(DeviceEntity deviceEntity) {
        if ( deviceEntity == null ) {
            return null;
        }

        Device device = new Device();

        device.setId( deviceEntity.getId() );
        device.setUserId( deviceEntity.getUserId() );
        device.setDeviceHardwareId( deviceEntity.getDeviceHardwareId() );
        device.setFCMToken( deviceEntity.getFCMToken() );

        return device;
    }
}
