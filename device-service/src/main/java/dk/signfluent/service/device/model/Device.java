package dk.signfluent.service.device.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Device {
    private UUID id;
    private UUID userId;
    private String deviceHardwareId;
    private String FCMToken;
}
