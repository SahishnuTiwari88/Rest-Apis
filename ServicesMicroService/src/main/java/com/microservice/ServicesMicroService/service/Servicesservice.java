package com.microservice.ServicesMicroService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.ServicesMicroService.dao.ServicesRepository;
import com.microservice.ServicesMicroService.entities.Services;

@Service
public class Servicesservice {
	@Autowired
	private ServicesRepository servrepo;
	
	
	public Services addService(Services service) {
		return servrepo.save(service);
	}
	
	public List<Services> getAllServices() {
		List<Services> findAll = servrepo.findAll();
		return findAll;
	}
	
	public Services findServiceById(int id) {
		Services services = servrepo.findById(id).orElseThrow(()->new IllegalArgumentException("Service id not found"));
		return services;
	}
}
