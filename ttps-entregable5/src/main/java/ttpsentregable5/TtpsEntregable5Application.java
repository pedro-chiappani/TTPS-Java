package ttpsentregable5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ttpsentregable5")
@EnableJpaRepositories
public class TtpsEntregable5Application {

	public static void main(String[] args) {
		SpringApplication.run(TtpsEntregable5Application.class, args);
	}

}
