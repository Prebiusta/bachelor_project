package dk.signfluent.service.notification.model;

import lombok.Data;

import java.util.List;

@Data
public class NotificationRequest {
    private List<String> receivers;
    private String messageText;
}
