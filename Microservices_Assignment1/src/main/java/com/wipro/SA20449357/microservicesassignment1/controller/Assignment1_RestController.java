package com.wipro.SA20449357.microservicesassignment1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.SA20449357.microservicesassignment1.entities.Patients;
import com.wipro.SA20449357.microservicesassignment1.entities.Services;
import com.wipro.SA20449357.microservicesassignment1.service.PatientService;
import com.wipro.SA20449357.microservicesassignment1.service.Servicespat;

@RestController
@RequestMapping("/")
public class Assignment1_RestController {
	@Autowired
	private PatientService patientser;
	@Autowired
	private Servicespat services;
	
	@PostMapping("addPatients")
	public Patients createPatients(@RequestBody Patients patients) {
		return patientser.addPatients(patients);
	}
	@GetMapping("patient/{id}")
	public Optional<Patients> getPatientById(@PathVariable Long id) {
		return patientser.getById(id);
	}
	@GetMapping
	public List<Patients> getAllPatients(){
		return patientser.getAllPatients();
		
	}
	
	@GetMapping("allservice")
	public List<Services> getAllservices(){
		return services.getAllService();
	}
	@GetMapping("service/{id}")
	public Optional<Services> getserviceById(@PathVariable Long id) {
		return services.getServiceById(id);
	}

}
