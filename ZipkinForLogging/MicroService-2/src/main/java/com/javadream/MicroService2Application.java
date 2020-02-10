package com.javadream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroService2Application {
	

	public static void main(String[] args) {
		SpringApplication.run(MicroService2Application.class, args);
	}

}
