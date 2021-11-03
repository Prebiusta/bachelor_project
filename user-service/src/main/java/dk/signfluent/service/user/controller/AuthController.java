package dk.signfluent.service.user.controller;

import dk.signfluent.integration.keycloak.model.AuthenticationRequest;
import dk.signfluent.integration.keycloak.model.AuthenticationResponse;
import dk.signfluent.integration.keycloak.model.RefreshTokenRequest;
import dk.signfluent.integration.keycloak.service.KeycloakUserManagementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final KeycloakUserManagementService keycloakUserManagementService;

    public AuthController(KeycloakUserManagementService keycloakUserManagementService) {
        this.keycloakUserManagementService = keycloakUserManagementService;
    }

    @PostMapping("/authenticate")
    @ApiOperation(value = "Authenticate User", nickname = "authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return keycloakUserManagementService.authenticate(authenticationRequest);
    }

    @PostMapping("/refreshToken")
    @ApiOperation(value = "Refreshes access token", nickname = "refreshToken")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return keycloakUserManagementService.refreshToken(refreshTokenRequest);
    }
}
