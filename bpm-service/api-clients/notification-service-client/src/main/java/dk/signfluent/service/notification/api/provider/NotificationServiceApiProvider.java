package dk.signfluent.service.notification.api.provider;

import dk.signfluent.notification.service.invoker.ApiException;
import dk.signfluent.notification.service.model.NotificationRequest;
import dk.signfluent.notification.service.model.NotificationResponse;

public interface NotificationServiceApiProvider {
    Long getNotificationTime() throws ApiException;

    Long modifyNotificationTime(Long time) throws ApiException;

    NotificationResponse sendPhoneNotification(NotificationRequest notificationRequest) throws ApiException;

    void sendEmailNotification(NotificationRequest notificationRequest) throws ApiException;
}
