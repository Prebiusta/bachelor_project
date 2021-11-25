package dk.signfluent.service.bpm.delegate;

import dk.signfluent.notification.service.model.NotificationRequest;
import dk.signfluent.service.device.api.provider.DeviceServiceApiProvider;
import dk.signfluent.service.notification.api.provider.NotificationServiceApiProvider;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;

import static dk.signfluent.service.bpm.utility.ProcessVariables.APPROVER;

@Component
@Slf4j
public class NotifyApproverDelegate implements JavaDelegate {
    private final DeviceServiceApiProvider deviceServiceApiProvider;
    private final NotificationServiceApiProvider notificationServiceApiProvider;

    public NotifyApproverDelegate(DeviceServiceApiProvider deviceServiceApiProvider, NotificationServiceApiProvider notificationServiceApiProvider) {
        this.deviceServiceApiProvider = deviceServiceApiProvider;
        this.notificationServiceApiProvider = notificationServiceApiProvider;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<String> fcmTokensForUser = deviceServiceApiProvider.getFCMTokensForUser((String) delegateExecution.getVariable(APPROVER));
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setReceivers(fcmTokensForUser);
        notificationRequest.setMessageText("Please sign this");
        notificationServiceApiProvider.sendPhoneNotification(notificationRequest);
    }
}
