package com.microservice.ServicesMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
//@EnableDiscoveryClient
//@LoadBalancerClient(name="SERVICES-MS")
@SpringBootApplication
public class ServicesMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesMicroServiceApplication.class, args);
	}

}
