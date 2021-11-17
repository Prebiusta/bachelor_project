package dk.signfluent.service.notification.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import dk.signfluent.service.notification.model.NotificationRequest;
import dk.signfluent.service.notification.model.NotificationResponse;
import dk.signfluent.service.notification.service.NotificationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendPhoneNotification")
    @ApiOperation(value = "Sends a notification to specified FCM tokens", nickname = "sendPhoneNotification")
    public NotificationResponse sendPhoneNotification(@RequestBody NotificationRequest notificationRequest) throws FirebaseMessagingException {
        return notificationService.sendPhoneNotifications(notificationRequest);
    }

    @PostMapping("/sendEmailNotification")
    @ApiOperation(value = "Sends a notification to specified emails", nickname = "sendEmailNotification")
    public void sendEmailNotification(@RequestBody NotificationRequest notificationRequest)  {
        notificationService.sendEmailNotifications(notificationRequest);
    }

    @GetMapping("/getNotificationTime")
    @ApiOperation(value = "Get notification time", nickname = "getNotificationTime")
    public long getNotificationTime() {
        return notificationService.getNotificationTime();
    }

    @PostMapping("/modifyNotificationTime")
    @ApiOperation(value = "Modify time of daily reminders", nickname = "modifyNotificationTime")
    public long modifyNotificationTime(@RequestParam long time) {
        return notificationService.modifyNotificationTime(time);
    }

}
