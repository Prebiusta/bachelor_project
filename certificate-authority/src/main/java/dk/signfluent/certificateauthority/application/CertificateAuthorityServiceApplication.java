package dk.signfluent.certificateauthority.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dk.signfluent.certificateauthority")
public class CertificateAuthorityServiceApplication {

  public static void main(String... args) {
    SpringApplication.run(CertificateAuthorityServiceApplication.class, args);
  }

}