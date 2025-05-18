package com.microservice.PatientsMicroService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.PatientsMicroService.entities.Services;

@FeignClient(name="SERVICES-MS")
public interface ServicesService {
	@PostMapping("/service/addService")
	Services addService(@RequestBody Services servi);
	
	@GetMapping("/service/all")
	List<Services> getAllService();
	
	@GetMapping("/service/{id}")
	Services getServiceById(@PathVariable int id);

}
