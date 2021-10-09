package dk.signfluent.service.notification.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import dk.signfluent.service.notification.model.NotificationRequest;
import dk.signfluent.service.notification.model.NotificationResponse;
import dk.signfluent.service.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public NotificationResponse sendSignatureNotification(@RequestBody NotificationRequest notificationRequest) throws FirebaseMessagingException {
        return notificationService.sendSignatureNotifications(notificationRequest);
    }

}
