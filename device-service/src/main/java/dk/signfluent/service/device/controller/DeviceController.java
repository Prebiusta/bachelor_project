package dk.signfluent.service.device.controller;

import dk.signfluent.service.device.model.Device;
import dk.signfluent.service.device.model.request.RegisterDeviceRequest;
import dk.signfluent.service.device.model.request.UpdateFCMTokenRequest;
import dk.signfluent.service.device.model.request.UserBasedRequest;
import dk.signfluent.service.device.model.response.RegisterDeviceResponse;
import dk.signfluent.service.device.model.response.UpdateFCMTokenResponse;
import dk.signfluent.service.device.service.DeviceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/getDevicesForUser")
    @ApiOperation(value = "Get Devices For User", nickname = "getDevicesForUser")
    public List<Device> getDevicesForUser(@RequestBody UserBasedRequest userBasedRequest) {
        return deviceService.getDevicesForUser(userBasedRequest.getUserId());
    }

    @PostMapping("/getFCMTokensForUser")
    @ApiOperation(value = "Update FCM Token", nickname = "getFCMTokensForUser")
    public List<String> getFCMTokensForUser(@RequestBody UserBasedRequest userBasedRequest) {
        return deviceService.getFCMTokensForUser(userBasedRequest.getUserId());
    }

    @PostMapping("/registerDevice")
    @ApiOperation(value = "Register Device", nickname = "registerDevice")
    public RegisterDeviceResponse registerDevice(@RequestBody RegisterDeviceRequest registerDeviceRequest) throws RuntimeException {
        return deviceService.registerDevice(registerDeviceRequest);
    }

    @PostMapping("/updateFCMToken")
    @ApiOperation(value = "Update FCM Token", nickname = "updateFCMToken")
    public UpdateFCMTokenResponse updateFCMToken(@RequestBody UpdateFCMTokenRequest updateFCMTokenRequest) throws RuntimeException {
        return deviceService.updateFCMToken(updateFCMTokenRequest);
    }
}
