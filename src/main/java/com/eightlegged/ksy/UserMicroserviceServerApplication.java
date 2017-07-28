package com.eightlegged.ksy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.eightlegged.ksy")
public class UserMicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceServerApplication.class, args);
	}
	
}
