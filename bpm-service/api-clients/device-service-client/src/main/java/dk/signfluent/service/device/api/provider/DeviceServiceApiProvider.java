package dk.signfluent.service.device.api.provider;


import dk.signfluent.ca.invoker.ApiException;
import dk.signfluent.ca.model.*;

import java.util.List;

public interface DeviceServiceApiProvider {
    List<Device> getDevicesForUser(String userId) throws ApiException;

    List<String> getFCMTokensForUser(String userId) throws ApiException;

    RegisterDeviceResponse registerDevice(RegisterDeviceRequest registerDeviceRequest) throws ApiException;

    UpdateFCMTokenResponse updateFCMToken(UpdateFCMTokenRequest updateFCMTokenRequest) throws ApiException;
}
