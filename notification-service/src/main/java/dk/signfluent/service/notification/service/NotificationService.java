package dk.signfluent.service.notification.service;

import com.google.firebase.messaging.*;
import dk.signfluent.service.notification.config.EmailConfig;
import dk.signfluent.service.notification.entity.NotificationTime;
import dk.signfluent.service.notification.model.NotificationRequest;
import dk.signfluent.service.notification.model.NotificationResponse;
import dk.signfluent.service.notification.repository.NotificationTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    private final FirebaseMessaging firebaseMessaging;
    private final NotificationTimeRepository repository;
    private final JavaMailSender emailSender;
    private final EmailConfig emailConfig;

    public NotificationService(FirebaseMessaging firebaseMessaging, NotificationTimeRepository repository, JavaMailSender emailSender, EmailConfig emailConfig) {
        this.firebaseMessaging = firebaseMessaging;
        this.repository = repository;
        this.emailSender = emailSender;
        this.emailConfig = emailConfig;
    }

    public NotificationResponse sendPhoneNotifications(NotificationRequest notificationRequest) throws FirebaseMessagingException {
        BatchResponse batchResponse = firebaseMessaging.sendAll(extractMessageList(notificationRequest));
        return new NotificationResponse(batchResponse.getSuccessCount(), batchResponse.getFailureCount());
    }

    public void sendEmailNotifications(NotificationRequest notificationRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getUsername());
        message.setSubject("Signfluent notification");
        message.setText(notificationRequest.getMessageText());

        for (String receiver : notificationRequest.getReceivers())
        {
            message.setTo(receiver);
            emailSender.send(message);
        }
    }

    public long getNotificationTime() {
        var notificationTime = repository.findAll();

        return notificationTime.size() != 0 ?  notificationTime.get(0).getTime().getTime(): repository.save(new NotificationTime(new Time(39600000))).getTime().getTime();
    }

    public long modifyNotificationTime(long time)
    {
        var notificationTime = repository.findAll();
        if (notificationTime.size() != 0)
        {
            notificationTime.get(0).setTime(new Time(time));
            repository.save(notificationTime.get(0));
            return time;
        }
        return repository.save(new NotificationTime(new Time(time))).getTime().getTime();
    }

    private List<Message> extractMessageList(NotificationRequest notificationRequest) {
        return notificationRequest.getReceivers()
                .stream()
                .map(s -> createFirebaseMessage(s, notificationRequest.getMessageText()))
                .collect(Collectors.toList());
    }

    private Message createFirebaseMessage(String token, String message) {
        return Message.builder()
                .setNotification(Notification.builder()
                        .setTitle("Signfluent")
                        .setBody(message)
                        .build())
                .setToken(token)
                .build();
    }
}
