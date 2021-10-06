package dk.signfluent.service.user.model.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
