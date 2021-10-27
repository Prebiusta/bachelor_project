package dk.signfluent.service.bpm.controller;

import dk.signfluent.service.user.api.provider.UserServiceApiProvider;
import dk.signfluent.user.service.invoker.ApiException;
import dk.signfluent.user.service.model.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PermitAll
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws ApiException {
        return userServiceApiProvider.authenticate(authenticationRequest);
    }

    @PostMapping("/refreshToken")
    @PermitAll
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest request) throws ApiException {
        return userServiceApiProvider.refreshToken(request);
    }

    @PostMapping("/createUser")
    @PreAuthorize(ADMINISTRATOR)
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest) throws ApiException {
        return userServiceApiProvider.createUserAccount(userCreateRequest);
    }
}
