package dk.signfluent.service.bpm.controller;

import dk.signfluent.ca.invoker.ApiException;
import dk.signfluent.ca.model.RegisterDeviceRequest;
import dk.signfluent.ca.model.RegisterDeviceResponse;
import dk.signfluent.ca.model.UpdateFCMTokenRequest;
import dk.signfluent.ca.model.UpdateFCMTokenResponse;
import dk.signfluent.service.device.api.provider.DeviceServiceApiProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dk.signfluent.service.bpm.utility.AuthorizationTypes.APPROVER;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    private final DeviceServiceApiProvider deviceServiceApiProvider;

    public DeviceController(DeviceServiceApiProvider deviceServiceApiProvider) {
        this.deviceServiceApiProvider = deviceServiceApiProvider;
    }

    @PostMapping("/register")
    @ApiOperation(value = "Registers a new device", nickname = "register")
    @PreAuthorize(APPROVER)
    public RegisterDeviceResponse registerDevice(@RequestBody RegisterDeviceRequest request) throws ApiException {
        return deviceServiceApiProvider.registerDevice(request);
    }

    @PostMapping("/updateFCMToken")
    @ApiOperation(value = "Updates FCM token for specified device", nickname = "updateFCMToken")
    @PreAuthorize(APPROVER)
    public UpdateFCMTokenResponse updateFCMToken(@RequestBody UpdateFCMTokenRequest updateFCMTokenRequest) throws ApiException {
        return deviceServiceApiProvider.updateFCMToken(updateFCMTokenRequest);
    }
}
