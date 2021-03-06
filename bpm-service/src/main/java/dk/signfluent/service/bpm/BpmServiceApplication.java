package dk.signfluent.service.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dk.signfluent")
public class BpmServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(BpmServiceApplication.class, args);
    }

}