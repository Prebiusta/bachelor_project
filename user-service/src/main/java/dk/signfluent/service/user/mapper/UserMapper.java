package dk.signfluent.service.user.mapper;

import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User mapUserEntityToModel(UserEntity userEntity);
}
