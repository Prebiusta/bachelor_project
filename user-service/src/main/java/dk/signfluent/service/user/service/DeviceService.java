package dk.signfluent.service.user.service;

import dk.signfluent.service.user.entity.DeviceEntity;
import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.model.request.DeviceBasedRequest;
import dk.signfluent.service.user.model.request.RegisterDeviceRequest;
import dk.signfluent.service.user.model.request.UpdateFCMTokenRequest;
import dk.signfluent.service.user.model.response.DeviceEntityResponse;
import dk.signfluent.service.user.model.response.RegisterDeviceResponse;
import dk.signfluent.service.user.model.response.UpdateFCMTokenResponse;
import dk.signfluent.service.user.provider.DeviceCRUDProvider;
import dk.signfluent.service.user.provider.UserCRUDProvider;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private final DeviceCRUDProvider deviceCRUDProvider;
    private final UserCRUDProvider userCRUDProvider;

    public DeviceService(DeviceCRUDProvider deviceCRUDProvider, UserCRUDProvider userCRUDProvider) {
        this.deviceCRUDProvider = deviceCRUDProvider;
        this.userCRUDProvider = userCRUDProvider;
    }

    public RegisterDeviceResponse registerDevice(RegisterDeviceRequest registerDeviceRequest) {
        verifyExistingDevice(registerDeviceRequest);
        DeviceEntity deviceEntity = deviceCRUDProvider.create(createDeviceForUser(registerDeviceRequest));
        return new RegisterDeviceResponse(deviceEntity);
    }

    public UpdateFCMTokenResponse updateFCMToken(UpdateFCMTokenRequest updateFCMTokenRequest) {
        DeviceEntity deviceEntity = getDeviceForUserIdAndUser(updateFCMTokenRequest);
        deviceEntity.setFCMToken(updateFCMTokenRequest.getFcmToken());
        DeviceEntity updatedEntity = deviceCRUDProvider.update(deviceEntity);
        return new UpdateFCMTokenResponse(updatedEntity);
    }

    private DeviceEntity getDeviceForUserIdAndUser(DeviceBasedRequest deviceBasedRequest) {
        return userCRUDProvider.getAllDevicesForUser(deviceBasedRequest.getUserId())
                .stream()
                .filter(device -> device.getDeviceId().equals(deviceBasedRequest.getDeviceId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private void verifyExistingDevice(DeviceBasedRequest deviceBasedRequest) {
        List<DeviceEntity> foundDeviceEntity = userCRUDProvider
                .getAllDevicesForUser(deviceBasedRequest.getUserId())
                .stream()
                .filter(device -> device.getDeviceId().equals(deviceBasedRequest.getDeviceId()))
                .collect(Collectors.toList());

        if (foundDeviceEntity.size() != 0)
            throw new RuntimeException("Device is already set up for specified user");
    }

    private DeviceEntity createDeviceForUser(RegisterDeviceRequest registerDeviceRequest) {
        UserEntity userEntity = userCRUDProvider.get(registerDeviceRequest.getUserId());
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setDeviceId(registerDeviceRequest.getDeviceId());
        deviceEntity.setUser(userEntity);
        return deviceEntity;
    }
}
