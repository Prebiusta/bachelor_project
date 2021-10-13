package dk.signfluent.service.user.controller;

import dk.signfluent.service.user.model.request.RegisterDeviceRequest;
import dk.signfluent.service.user.model.request.UpdateFCMTokenRequest;
import dk.signfluent.service.user.model.response.RegisterDeviceResponse;
import dk.signfluent.service.user.model.response.UpdateFCMTokenResponse;
import dk.signfluent.service.user.service.DeviceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deviceManagement")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/registerDevice")
    public RegisterDeviceResponse registerDevice(@RequestBody RegisterDeviceRequest registerDeviceRequest) throws RuntimeException {
        return deviceService.registerDevice(registerDeviceRequest);
    }

    @PostMapping("/updateFCMToken")
    public UpdateFCMTokenResponse updateFCMToken(@RequestBody UpdateFCMTokenRequest updateFCMTokenRequest) throws RuntimeException {
        return deviceService.updateFCMToken(updateFCMTokenRequest);
    }
}
