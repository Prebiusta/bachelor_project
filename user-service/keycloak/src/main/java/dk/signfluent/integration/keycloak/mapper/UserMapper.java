package dk.signfluent.integration.keycloak.mapper;

import dk.signfluent.integration.keycloak.model.User;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User mapUserRepresentationToUser(UserRepresentation userRepresentation);

    List<User> mapUserRepresentationListToUser(List<UserRepresentation> userRepresentationList);
}
