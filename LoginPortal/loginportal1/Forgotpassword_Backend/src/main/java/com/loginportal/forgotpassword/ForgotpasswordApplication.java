package com.loginportal.forgotpassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@SpringBootApplication
@EnableTransactionManagement
public class ForgotpasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForgotpasswordApplication.class, args);
        
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
