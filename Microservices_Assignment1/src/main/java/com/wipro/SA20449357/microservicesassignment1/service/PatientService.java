package com.wipro.SA20449357.microservicesassignment1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.SA20449357.microservicesassignment1.dao.PatientRepo;
import com.wipro.SA20449357.microservicesassignment1.entities.Patients;

@Service
public class PatientService {
	@Autowired
	private PatientRepo patientrepo;
	
	public Patients addPatients(Patients patients) {
		return patientrepo.save(patients);
		
	}
	
	public Optional<Patients> getById(Long id) {
		return patientrepo.findById(id);
	}
	
	public List<Patients> getAllPatients(){
		return patientrepo.findAll();
	}

}
