package app.reserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = "app.reserve")
public class ReserveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReserveApplication.class, args);
    }
}

