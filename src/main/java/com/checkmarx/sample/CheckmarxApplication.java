package com.checkmarx.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point into the spring boot application
 * com.checkmarx.sdk is required to autowire the SDK
 */
@SpringBootApplication(scanBasePackages={"com.checkmarx.sdk", "com.checkmarx.sample"})
public class CheckmarxApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CheckmarxApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		SpringApplication.exit(app.run(args));
	}
}
