package dk.signfluent.service.user.provider;

import dk.signfluent.service.user.entity.UserEntity;
import dk.signfluent.service.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserCRUDProvider {
    private final UserRepository userRepository;

    public UserCRUDProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity get(UUID userId) {
        return userRepository.getById(userId);
    }

    public UserEntity getByEmail(String email) {
        return userRepository
                .getByEmail(email)
                .orElseThrow(() -> new RuntimeException("User with specified email not found"));
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void delete(UUID userId) {
        userRepository.deleteById(userId);
    }
}
