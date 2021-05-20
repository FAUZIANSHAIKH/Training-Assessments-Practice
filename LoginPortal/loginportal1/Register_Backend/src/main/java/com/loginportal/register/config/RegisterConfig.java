package com.loginportal.register.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.loginportal.register.model.CustomPasswordEncoder;

@Configuration
public class RegisterConfig {

	@Bean
    public CustomPasswordEncoder customPasswordEncoder() {
        return new CustomPasswordEncoder();
    }
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
