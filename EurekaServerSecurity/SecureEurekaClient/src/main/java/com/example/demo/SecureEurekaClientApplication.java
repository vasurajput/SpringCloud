package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SecureEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureEurekaClientApplication.class, args);
	}

}
