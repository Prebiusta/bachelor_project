package dk.signfluent.businessservice.controller.api;

import dk.signfluent.businessservice.model.request.ModifyDailyNotificationTimeRequest;
import dk.signfluent.notification.service.invoker.ApiException;
import dk.signfluent.service.notification.api.provider.NotificationServiceApiProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dk.signfluent.businessservice.utility.AuthorizationTypes.ADMINISTRATOR;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationServiceApiProvider notificationServiceApiProvider;

    public NotificationController(NotificationServiceApiProvider notificationServiceApiProvider) {
        this.notificationServiceApiProvider = notificationServiceApiProvider;
    }

    @PostMapping("/getDailyNotificationTime")
    @ApiOperation(value = "Returns time of daily notifications", nickname = "getDailyNotificationTime")
    @PreAuthorize(ADMINISTRATOR)
    public Long getDailyNotificationTime() throws ApiException {
        return notificationServiceApiProvider.getNotificationTime();
    }

    @PostMapping("/modifyDailyNotificationTime")
    @ApiOperation(value = "Modify time of daily notifications", nickname = "modifyDailyNotificationTime")
    @PreAuthorize(ADMINISTRATOR)
    public Long modifyDailyNotificationTime(@RequestBody ModifyDailyNotificationTimeRequest modifyDailyNotificationTimeRequest) throws ApiException {
        return notificationServiceApiProvider.modifyNotificationTime(modifyDailyNotificationTimeRequest.getNotificationTime());
    }
}
