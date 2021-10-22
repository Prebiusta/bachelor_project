package dk.signfluent.service.user.service;

import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.mapper.UserMapper;
import dk.signfluent.service.user.model.User;
import dk.signfluent.service.user.model.request.AuthenticationRequest;
import dk.signfluent.service.user.model.response.AuthenticationResponse;
import dk.signfluent.service.user.provider.UserCRUDProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserCRUDProvider userCRUDProvider;
    private final UserMapper userMapper;

    public UserService(UserCRUDProvider userCRUDProvider, UserMapper userMapper) {
        this.userCRUDProvider = userCRUDProvider;
        this.userMapper = userMapper;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        UserEntity userEntity = userCRUDProvider.getByEmail(authenticationRequest.getEmail());
        if (userEntity.getPassword().matches(authenticationRequest.getPassword()))
            return new AuthenticationResponse(userMapper.mapUserEntityToModel(userEntity));
        throw new RuntimeException("Password does not match");
    }

    public List<User> getAvailableApproves() {
        return userCRUDProvider
                .getAll()
                .stream()
                .map(userMapper::mapUserEntityToModel)
                .collect(Collectors.toList());
    }
}
