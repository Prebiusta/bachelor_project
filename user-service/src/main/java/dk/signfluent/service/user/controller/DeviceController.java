package dk.signfluent.service.user.controller;

import dk.signfluent.service.ca.model.IssueX509CertificateRequest;
import dk.signfluent.service.user.model.request.RegisterDeviceRequest;
import dk.signfluent.service.user.model.request.UpdateFCMTokenRequest;
import dk.signfluent.service.user.model.response.RegisterDeviceResponse;
import dk.signfluent.service.user.model.response.UpdateFCMTokenResponse;
import dk.signfluent.service.user.service.DeviceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/deviceManagement")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping(path = "/registerDevice", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RegisterDeviceResponse registerDevice(@RequestBody RegisterDeviceRequest registerDeviceRequest) throws RuntimeException {
        return deviceService.registerDevice(registerDeviceRequest);
    }

    @PostMapping(path = "/updateFCMToken", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UpdateFCMTokenResponse updateFCMToken(@RequestBody UpdateFCMTokenRequest updateFCMTokenRequest) throws RuntimeException {
        return deviceService.updateFCMToken(updateFCMTokenRequest);
    }
}
