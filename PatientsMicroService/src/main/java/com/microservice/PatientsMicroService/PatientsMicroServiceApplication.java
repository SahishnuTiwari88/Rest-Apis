package com.microservice.PatientsMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaClient
//@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
//@LoadBalancerClient(name="PATIENT-MS")
public class PatientsMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMicroServiceApplication.class, args);
	}

}
