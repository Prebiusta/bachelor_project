package dk.signfluent.businessservice.model.response;

import dk.signfluent.user.service.model.User;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserActionResponse {
    private OffsetDateTime date;
    private User user;
}
