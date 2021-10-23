package dk.signfluent.service.device.repository;

import dk.signfluent.service.device.entity.DeviceEntity;
import dk.signfluent.service.device.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, UUID> {
    List<DeviceEntity> findAllByUserId(UUID userId);
    Optional<DeviceEntity> findFirstByDeviceHardwareIdAndUserId(String deviceHardwareId, UUID userId);
}
