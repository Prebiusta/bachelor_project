package dk.signfluent.businessservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyDailyNotificationTimeRequest {
    private Long notificationTime;
}
