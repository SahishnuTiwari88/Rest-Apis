package com.wipro.SA20449357.microservicesassignment1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.SA20449357.microservicesassignment1.dao.ServiceRepo;
import com.wipro.SA20449357.microservicesassignment1.entities.Services;
@Service
public class Servicespat {
	@Autowired
	private ServiceRepo servicerepo;
	
	
	public List<Services> getAllService(){
		  return servicerepo.findAll();
	}
	
	public Optional<Services> getServiceById(Long id) {
		return servicerepo.findById(id);
	}
}
