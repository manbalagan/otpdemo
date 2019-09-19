package org.mano.otpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.mano.otpdemo")
public class OTPApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTPApplication.class, args);
	}
}
