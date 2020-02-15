package com.javadream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class SpringBootSecurityWithJwtAndMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityWithJwtAndMysqlApplication.class, args);
	}

}
