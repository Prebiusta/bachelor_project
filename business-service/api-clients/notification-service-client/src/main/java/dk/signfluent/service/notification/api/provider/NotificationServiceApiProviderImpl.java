package dk.signfluent.service.notification.api.provider;

import dk.signfluent.notification.service.api.NotificationControllerApi;
import dk.signfluent.notification.service.invoker.ApiException;
import dk.signfluent.notification.service.model.NotificationRequest;
import dk.signfluent.notification.service.model.NotificationResponse;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceApiProviderImpl implements NotificationServiceApiProvider {
    private final NotificationControllerApi notificationControllerApi;

    public NotificationServiceApiProviderImpl(NotificationControllerApi notificationControllerApi) {
        this.notificationControllerApi = notificationControllerApi;
    }

    @Override
    public Long getNotificationTime() throws ApiException {
        return notificationControllerApi.getNotificationTime();
    }

    @Override
    public Long modifyNotificationTime(Long time) throws ApiException {
        return notificationControllerApi.modifyNotificationTime(time);
    }

    @Override
    public NotificationResponse sendPhoneNotification(NotificationRequest notificationRequest) throws ApiException {
        return notificationControllerApi.sendPhoneNotification(notificationRequest);
    }

    @Override
    public void sendEmailNotification(NotificationRequest notificationRequest) throws ApiException {
        notificationControllerApi.sendEmailNotification(notificationRequest);
    }
}
