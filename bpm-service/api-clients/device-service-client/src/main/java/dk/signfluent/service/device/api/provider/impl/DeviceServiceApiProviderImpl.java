package dk.signfluent.service.device.api.provider.impl;

import dk.signfluent.ca.api.DeviceControllerApi;
import dk.signfluent.ca.invoker.ApiException;
import dk.signfluent.ca.model.*;
import dk.signfluent.service.device.api.provider.DeviceServiceApiProvider;
import dk.signfluent.service.device.api.service.UserRequestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DeviceServiceApiProviderImpl implements DeviceServiceApiProvider {
    private final UserRequestService userRequestService;
    private final DeviceControllerApi deviceControllerApi;

    public DeviceServiceApiProviderImpl(UserRequestService userRequestService, DeviceControllerApi deviceControllerApi) {
        this.userRequestService = userRequestService;
        this.deviceControllerApi = deviceControllerApi;
    }


    @Override
    public List<Device> getDevicesForUser(String userId) throws ApiException {
        return deviceControllerApi.getDevicesForUser(userRequestService.generateUserBasedRequest(userId));
    }

    @Override
    public List<String> getFCMTokensForUser(String userId) throws ApiException {
        return deviceControllerApi.getFCMTokensForUser(userRequestService.generateUserBasedRequest(userId));
    }

    @Override
    public RegisterDeviceResponse registerDevice(RegisterDeviceRequest registerDeviceRequest) throws ApiException {
        return deviceControllerApi.registerDevice(registerDeviceRequest);
    }

    @Override
    public UpdateFCMTokenResponse updateFCMToken(UpdateFCMTokenRequest updateFCMTokenRequest) throws ApiException {
        return deviceControllerApi.updateFCMToken(updateFCMTokenRequest);
    }
}
