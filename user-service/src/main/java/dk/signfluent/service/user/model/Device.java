package dk.signfluent.service.user.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Device {
    private UUID id;
    private String deviceIdentifier;
    private String FCMToken;
}
