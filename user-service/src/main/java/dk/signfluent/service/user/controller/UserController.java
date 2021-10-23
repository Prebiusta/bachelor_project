package dk.signfluent.service.user.controller;

import dk.signfluent.service.user.model.User;
import dk.signfluent.service.user.model.request.AuthenticationRequest;
import dk.signfluent.service.user.model.response.AuthenticationResponse;
import dk.signfluent.service.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    @ApiOperation(value = "Authenticate User", nickname = "authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return userService.authenticate(authenticationRequest);
    }

    @PostMapping("/getAvailableApprovers")
    @ApiOperation(value = "Get Available Approvers", nickname = "getAvailableApprovers")
    public List<User> getAvailableApprovers() {
        return userService.getAvailableApproves();
    }
}
