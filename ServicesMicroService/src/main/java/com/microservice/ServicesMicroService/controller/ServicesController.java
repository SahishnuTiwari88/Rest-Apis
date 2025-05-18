package com.microservice.ServicesMicroService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ServicesMicroService.entities.Services;
import com.microservice.ServicesMicroService.service.Servicesservice;

@RestController
@RequestMapping("/service")
public class ServicesController {
	@Autowired
	private Servicesservice servi;

	@PostMapping("/addService")
	public ResponseEntity<Services> addServices(@RequestBody Services service) {
		Services addService = servi.addService(service);
		return ResponseEntity.status(HttpStatus.CREATED).body(addService);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Services>> getAllService(){
		List<Services> allServices = servi.getAllServices();
		return ResponseEntity.ok(allServices);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Services> serviceById(@PathVariable int id){
		Services findServiceById = servi.findServiceById(id);
		return ResponseEntity.ok(findServiceById);
	}
}
