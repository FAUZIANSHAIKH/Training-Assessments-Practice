package com.loginportal.deregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class DeregisterBackendApplication {
	public static void main(String[] argv) {
		SpringApplication.run(DeregisterBackendApplication.class, argv);
	}
}
