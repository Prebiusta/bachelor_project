package dk.signfluent.service.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dk.signfluent")
public class DeviceServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(DeviceServiceApplication.class, args);
    }

}
