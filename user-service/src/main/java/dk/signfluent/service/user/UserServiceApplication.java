package dk.signfluent.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dk.signfluent")
public class UserServiceApplication {

  public static void main(String... args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }



}