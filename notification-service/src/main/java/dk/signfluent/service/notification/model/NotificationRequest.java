package dk.signfluent.service.notification.model;

import lombok.Data;

import java.util.List;

@Data
public class NotificationRequest {
    private List<String> tokens;
    private String messageText;
}
