package dk.signfluent.service.notification;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApplication {

  public static void main(String... args) {
    SpringApplication.run(NotificationServiceApplication.class, args);
  }

}