package dk.signfluent.service.notification.service;

import com.google.firebase.messaging.*;
import dk.signfluent.service.notification.model.NotificationRequest;
import dk.signfluent.service.notification.model.NotificationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    private final FirebaseMessaging firebaseMessaging;

    public NotificationService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public NotificationResponse sendSignatureNotifications(NotificationRequest notificationRequest) throws FirebaseMessagingException {
        BatchResponse batchResponse = firebaseMessaging.sendAll(extractMessageList(notificationRequest));
        return new NotificationResponse(batchResponse.getSuccessCount(), batchResponse.getFailureCount());
    }

    private List<Message> extractMessageList(NotificationRequest notificationRequest) {
        return notificationRequest.getTokens()
                .stream()
                .map(s -> createFirebaseMessage(s, notificationRequest.getMessageText()))
                .collect(Collectors.toList());
    }

    private Message createFirebaseMessage(String token, String message) {
        return Message.builder()
                .setNotification(Notification.builder()
                        .setTitle("Signature Request")
                        .setBody(message)
                        .build())
                .setToken(token)
                .build();
    }
}
