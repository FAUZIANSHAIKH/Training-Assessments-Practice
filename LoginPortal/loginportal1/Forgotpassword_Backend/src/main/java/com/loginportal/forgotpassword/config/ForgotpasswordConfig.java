package com.loginportal.forgotpassword.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loginportal.forgotpassword.model.CustomPasswordEncoder;

@Configuration
public class ForgotpasswordConfig {
@Bean
	public CustomPasswordEncoder custompasswordencoder()
	{
	return new CustomPasswordEncoder();
	}

}
