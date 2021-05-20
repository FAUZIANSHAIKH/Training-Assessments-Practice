package com.loginportal.forgotpassword.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.loginportal.forgotpassword"))
                .paths(regex("/forgotpassword.*"))
                .build()
                .apiInfo(metaInfo());
    }
    @SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {
    	
    	return new ApiInfo("REST Api Documentation",
                "REST Api Documentation",
                "1.0",
                "urn:tos",
                new Contact("", "", ""),
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());

		/*
		 * ApiInfo apiInfo = new ApiInfo( "Spring Boot Swagger Example API",
		 * "Spring Boot Swagger Example API for Forgot Password Service", "1.0",
		 * "Terms of Service", new Contact("Sapient", "", ""), "", "" );
		 * 
		 * return apiInfo;
		 */
    }
}

