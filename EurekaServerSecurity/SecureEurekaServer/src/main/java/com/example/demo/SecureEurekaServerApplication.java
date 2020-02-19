package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableEurekaServer
@EnableWebSecurity
@SpringBootApplication
public class SecureEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureEurekaServerApplication.class, args);
	}

}
