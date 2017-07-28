package br.com.t4k;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="br.com.t4k")
public class UserMicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceServerApplication.class, args);
	}
	
}
