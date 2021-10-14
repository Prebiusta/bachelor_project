package dk.signfluent.service.bpm;

import dk.signfluent.user.service.invoker.ApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(scanBasePackages = "dk.signfluent")
public class BpmServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(BpmServiceApplication.class, args);
    }

}