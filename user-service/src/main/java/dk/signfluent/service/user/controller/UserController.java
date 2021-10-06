package dk.signfluent.service.user.controller;

import dk.signfluent.service.user.model.User;
import dk.signfluent.service.user.model.request.AuthenticationRequest;
import dk.signfluent.service.user.model.response.AuthenticationResponse;
import dk.signfluent.service.user.model.response.BaseResponse;
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

    @PostMapping(value = "/authenticate", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return userService.authenticate(authenticationRequest);
    }

    @GetMapping(value = "/getAvailableApprovers", produces = APPLICATION_JSON_VALUE)
    public List<User> getAvailableApprovers() {
        return userService.getAvailableApproves();
    }
}
