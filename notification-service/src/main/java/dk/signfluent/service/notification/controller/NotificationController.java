package dk.signfluent.service.notification.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import dk.signfluent.service.notification.model.NotificationRequest;
import dk.signfluent.service.notification.model.NotificationResponse;
import dk.signfluent.service.notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendPhoneNotification")
    public NotificationResponse sendPhoneNotification(@RequestBody NotificationRequest notificationRequest) throws FirebaseMessagingException {
        return notificationService.sendPhoneNotifications(notificationRequest);
    }

    @PostMapping("/sendEmailNotification")
    public void sendEmailNotification(@RequestBody NotificationRequest notificationRequest)  {
        notificationService.sendEmailNotifications(notificationRequest);
    }

    @GetMapping("/getNotificationTime")
    public long getNotificationTime() {
        return notificationService.getNotificationTime();
    }

    @PostMapping("/modifyNotificationTime")
    public long modifyNotificationTime(@RequestParam long time) {
        return notificationService.modifyNotificationTime(time);
    }

}
