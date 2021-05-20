package com.loginportal.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UserRegApplication {

	public static void main(String[] argv) {
		SpringApplication.run(UserRegApplication.class, argv);
	}

}
