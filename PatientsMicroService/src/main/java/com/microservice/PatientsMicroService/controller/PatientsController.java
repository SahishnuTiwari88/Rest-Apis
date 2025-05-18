package com.microservice.PatientsMicroService.controller;

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

import com.microservice.PatientsMicroService.entities.Patients;
import com.microservice.PatientsMicroService.entities.Services;
import com.microservice.PatientsMicroService.service.PatientsService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/patient")
public class PatientsController {
	@Autowired
	private PatientsService patientserv;
	@PostMapping("/add")
	public ResponseEntity<Patients> addPatient(@RequestBody Patients patient) {
		Patients addPatient = patientserv.addPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(addPatient);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Patients>> getAllPatients(){
		List<Patients> allPatients = patientserv.getAllPatients();
		return ResponseEntity.ok(allPatients);
	}
	@GetMapping("/patient/{id}")
	
	public ResponseEntity<Patients> getPatientById(@PathVariable int id){
		Patients patientById = patientserv.getPatientById(id);
		return ResponseEntity.ok(patientById);
	}
	@PostMapping("/addservice")
	@CircuitBreaker(name="patientsCircuitBreaker")
	public ResponseEntity<?> addServices(@RequestBody Services servi){
		patientserv.addService(servi);
		return ResponseEntity.ok("inserted services....");
		
	}
	@GetMapping("/allservice")
	@CircuitBreaker(name="patientsCircuitBreaker")
	public ResponseEntity<List<Services>> getAllServices(){
		List<Services> services = patientserv.getServices();
		return ResponseEntity.ok(services);
	}
	
	@GetMapping("/service/{id}")
	@CircuitBreaker(name="patientsCircuitBreaker")
	public ResponseEntity<Services> getServiceById(@PathVariable int id){
		Services servicebyId = patientserv.getServicebyId(id);
		return ResponseEntity.ok(servicebyId);
	}
}
