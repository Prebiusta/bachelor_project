package dk.signfluent.service.user;

import dk.signfluent.service.user.entity.DeviceEntity;
import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.provider.DeviceCRUDProvider;
import dk.signfluent.service.user.provider.UserCRUDProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {
    private final UserCRUDProvider userCRUDProvider;
    private final DeviceCRUDProvider deviceCRUDProvider;

    public DataLoader(UserCRUDProvider userCRUDProvider, DeviceCRUDProvider deviceCRUDProvider) {
        this.userCRUDProvider = userCRUDProvider;
        this.deviceCRUDProvider = deviceCRUDProvider;
    }

    @Override
    public void run(ApplicationArguments args) {
        UserEntity userEntity = userCRUDProvider.create(createUserEntity("user"));
        log.info(String.format("\n\nTest user UUID: [%s]\n", userEntity.getId()));
        log.info("Dummy entities successfully initialized");
        createTestUsersWithDevices();
    }

    private void createTestUsersWithDevices() {
        for (int i = 0; i < 10; i++)
            createUserEntityWithDevice(i);
    }

    private void createUserEntityWithDevice(int i) {
        UserEntity createdUser = userCRUDProvider.create(createUserEntity(String.format("User Temp #%s", i)));
        createdUser.setDeviceEntities(Collections.singletonList(createDeviceForUser(createdUser)));
        userCRUDProvider.update(createdUser);
    }

    private DeviceEntity createDeviceForUser(UserEntity userEntity) {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setUser(userEntity);
        deviceCRUDProvider.create(deviceEntity);
        return deviceEntity;
    }

    private UserEntity createUserEntity(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(name + "@signfluent.com");
        userEntity.setName(name);
        userEntity.setPassword("123456");
        return userEntity;
    }
}
