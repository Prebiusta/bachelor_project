package dk.signfluent.service.user.controller;

import dk.signfluent.service.user.model.Device;
import dk.signfluent.service.user.model.User;
import dk.signfluent.service.user.model.request.AuthenticationRequest;
import dk.signfluent.service.user.model.request.UserBasedRequest;
import dk.signfluent.service.user.model.response.AuthenticationResponse;
import dk.signfluent.service.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/userManagement")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return userService.authenticate(authenticationRequest);
    }

    @PostMapping("/getAvailableApprovers")
    public List<User> getAvailableApprovers() {
        return userService.getAvailableApproves();
    }

    @PostMapping("/getDevicesForUser")
    public List<Device> getDevicesForUser(@RequestBody UserBasedRequest userBasedRequest) {
        return userService.getDevicesForUser(userBasedRequest.getUserId());
    }

    @PostMapping("/getFCMTokensForUser")
    public List<String> getFCMTokensForUser(@RequestBody UserBasedRequest userBasedRequest) {
        return userService.getFCMTokens(userBasedRequest.getUserId());
    }
}
