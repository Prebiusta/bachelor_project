package dk.signfluent.service.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {
    private int successCount;
    private int failureCount;

    public static NotificationResponse failedNotificationResponse() {
        return new NotificationResponse(0, 0);
    }
}
