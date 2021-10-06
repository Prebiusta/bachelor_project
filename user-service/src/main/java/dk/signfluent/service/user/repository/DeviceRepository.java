package dk.signfluent.service.user.repository;

import dk.signfluent.service.user.entity.DeviceEntity;
import dk.signfluent.service.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, UUID> {
}
