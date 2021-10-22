package dk.signfluent.service.user;

import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.provider.UserCRUDProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {
    private final UserCRUDProvider userCRUDProvider;

    public DataLoader(UserCRUDProvider userCRUDProvider) {
        this.userCRUDProvider = userCRUDProvider;
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
        userCRUDProvider.create(createUserEntity(String.format("User Temp #%s", i)));
    }

    private UserEntity createUserEntity(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(name + "@signfluent.com");
        userEntity.setName(name);
        userEntity.setPassword("123456");
        return userEntity;
    }
}
