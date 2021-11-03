package dk.signfluent.service.bpm.controller.api;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

import static dk.signfluent.service.bpm.utility.AuthorizationTypes.ADMINISTRATOR;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserServiceApiProvider userServiceApiProvider;

    public AuthenticationController(UserServiceApiProvider userServiceApiProvider) {
        this.userServiceApiProvider = userServiceApiProvider;
    }

    @PostMapping("/login")
    @ApiOperation(value = "Authenticates user", nickname = "login")
    @PermitAll
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws ApiException {
        return userServiceApiProvider.authenticate(authenticationRequest);
    }

    @PostMapping("/refreshToken")
    @ApiOperation(value = "Refreshes authentication token", nickname = "refreshAuthToken")
    @PermitAll
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest request) throws ApiException {
        return userServiceApiProvider.refreshToken(request);
    }

    @PostMapping("/createUser")
    @ApiOperation(value = "Creates a new user", nickname = "createUser")
    @PreAuthorize(ADMINISTRATOR)
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest) throws ApiException {
        return userServiceApiProvider.createUserAccount(userCreateRequest);
    }

    @GetMapping("/ping")
    @ApiOperation(value = "Verifies the connection", nickname = "ping")
    @PermitAll
    public String ping() {
        return "pong";
    }
}
