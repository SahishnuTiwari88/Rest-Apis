package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//@SuppressWarnings("deprecation")

@EnableEurekaClient
@SpringBootApplication
public class SchoolMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolMicroServiceApplication.class, args);
	}

}
