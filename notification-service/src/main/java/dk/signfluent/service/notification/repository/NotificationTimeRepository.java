package dk.signfluent.service.notification.repository;

import dk.signfluent.service.notification.entity.NotificationTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationTimeRepository extends JpaRepository<NotificationTime, UUID> { }
