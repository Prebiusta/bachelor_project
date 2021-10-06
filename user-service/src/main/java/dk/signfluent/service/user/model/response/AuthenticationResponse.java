package dk.signfluent.service.user.model.response;

import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthenticationResponse extends BaseResponse{
    private User user;

    public AuthenticationResponse(User user) {
        this.user = user;
        setSuccessfulResponse();
    }
}
