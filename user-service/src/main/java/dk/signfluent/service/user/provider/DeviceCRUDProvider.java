package dk.signfluent.service.user.provider;

import dk.signfluent.service.user.entity.DeviceEntity;
import dk.signfluent.service.user.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceCRUDProvider {
    private final DeviceRepository deviceRepository;

    public DeviceCRUDProvider(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceEntity create(DeviceEntity deviceEntity) {
        return deviceRepository.save(deviceEntity);
    }

    public DeviceEntity get(UUID deviceId) {
        return deviceRepository.getById(deviceId);
    }

    public List<DeviceEntity> getAll() {
        return deviceRepository.findAll();
    }

    public DeviceEntity update(DeviceEntity deviceEntity) {
        return deviceRepository.save(deviceEntity);
    }

    public void delete(UUID deviceId) {
        deviceRepository.deleteById(deviceId);
    }
}
