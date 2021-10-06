package dk.signfluent.service.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceBasedRequest {
    private String deviceId;
    private UUID userId;
}
