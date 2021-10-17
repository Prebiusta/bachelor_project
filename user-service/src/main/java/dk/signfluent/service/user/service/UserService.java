package dk.signfluent.service.user.service;

import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.mapper.DeviceMapper;
import dk.signfluent.service.user.mapper.UserMapper;
import dk.signfluent.service.user.model.Device;
import dk.signfluent.service.user.model.User;
import dk.signfluent.service.user.model.request.AuthenticationRequest;
import dk.signfluent.service.user.model.response.AuthenticationResponse;
import dk.signfluent.service.user.provider.UserCRUDProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserCRUDProvider userCRUDProvider;
    private final UserMapper userMapper;
    private final DeviceMapper deviceMapper;

    public UserService(UserCRUDProvider userCRUDProvider, UserMapper userMapper, DeviceMapper deviceMapper) {
        this.userCRUDProvider = userCRUDProvider;
        this.userMapper = userMapper;
        this.deviceMapper = deviceMapper;
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
                .filter(userEntity -> userEntity.getDeviceEntities().size() != 0)
                .map(userMapper::mapUserEntityToModel)
                .collect(Collectors.toList());
    }

    public List<Device> getDevicesForUser(UUID userId) {
        return userCRUDProvider
                .get(userId)
                .getDeviceEntities()
                .stream()
                .map(deviceMapper::mapDeviceEntityToModel)
                .collect(Collectors.toList());
    }

    public List<String> getFCMTokens(UUID userId) {
        return getDevicesForUser(userId)
                .stream()
                .map(Device::getFCMToken)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
