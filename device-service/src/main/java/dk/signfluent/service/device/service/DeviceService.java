package dk.signfluent.service.device.service;

import dk.signfluent.service.device.entity.DeviceEntity;
import dk.signfluent.service.device.mapper.DeviceMapper;
import dk.signfluent.service.device.model.Device;
import dk.signfluent.service.device.model.DeviceServiceException;
import dk.signfluent.service.device.model.request.DeviceBasedRequest;
import dk.signfluent.service.device.model.request.RegisterDeviceRequest;
import dk.signfluent.service.device.model.request.UpdateFCMTokenRequest;
import dk.signfluent.service.device.model.response.RegisterDeviceResponse;
import dk.signfluent.service.device.model.response.UpdateFCMTokenResponse;
import dk.signfluent.service.device.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    public DeviceService(DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    public List<Device> getDevicesForUser(UUID userId) {
        return deviceRepository.findAllByUserId(userId)
                .stream()
                .map(deviceMapper::mapDeviceEntityToModel)
                .collect(Collectors.toList());
    }

    public List<String> getFCMTokensForUser(UUID userId) {
        return getDevicesForUser(userId)
                .stream()
                .map(Device::getFCMToken)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public RegisterDeviceResponse registerDevice(RegisterDeviceRequest registerDeviceRequest) {
        verifyRequiredRegisterDeviceAttributes(registerDeviceRequest);
        verifyExistingDevice(registerDeviceRequest);
        DeviceEntity deviceEntity = deviceRepository.save(generateDeviceEntity(registerDeviceRequest));
        return new RegisterDeviceResponse(deviceEntity);
    }

    public UpdateFCMTokenResponse updateFCMToken(UpdateFCMTokenRequest updateFCMTokenRequest) {
        DeviceEntity deviceEntity = getDeviceForHardwareIdAndUserId(updateFCMTokenRequest);
        deviceEntity.setFCMToken(updateFCMTokenRequest.getFcmToken());
        DeviceEntity updatedEntity = deviceRepository.save(deviceEntity);
        return new UpdateFCMTokenResponse(updatedEntity);
    }

    private void verifyRequiredRegisterDeviceAttributes(RegisterDeviceRequest registerDeviceRequest) {
        if (registerDeviceRequest.getDeviceHardwareId() == null
                || registerDeviceRequest.getUserId() == null)
            throw new DeviceServiceException("Missing required parameters");
    }

    private DeviceEntity getDeviceForHardwareIdAndUserId(UpdateFCMTokenRequest updateFCMTokenRequest) {
        return deviceRepository
                .findFirstByDeviceHardwareIdAndUserId(
                        updateFCMTokenRequest.getDeviceHardwareId(),
                        updateFCMTokenRequest.getUserId()
                )
                .orElseThrow(
                        () -> new DeviceServiceException("Device with HID " + updateFCMTokenRequest.getDeviceHardwareId() + " was not found for user " + updateFCMTokenRequest.getUserId())
                );
    }

    private void verifyExistingDevice(DeviceBasedRequest deviceBasedRequest) {
        boolean deviceExists = getDevicesForUser(deviceBasedRequest.getUserId())
                .stream()
                .anyMatch(device -> device.getDeviceHardwareId().equals(deviceBasedRequest.getDeviceHardwareId()));

        if (deviceExists)
            throw new DeviceServiceException("This Device is already set up for specified user");
    }

    private DeviceEntity generateDeviceEntity(RegisterDeviceRequest registerDeviceRequest) {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setDeviceHardwareId(registerDeviceRequest.getDeviceHardwareId());
        deviceEntity.setUserId(registerDeviceRequest.getUserId());
        return deviceEntity;
    }
}
