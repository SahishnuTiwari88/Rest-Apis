package com.microservice.PatientsMicroService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.PatientsMicroService.entities.Patients;
import com.microservice.PatientsMicroService.entities.Services;
import com.microservice.PatientsMicroService.feign.ServicesService;
import com.microservice.PatientsMicroService.repository.PatientsRepository;

@Service
public class PatientsService {
	@Autowired
	private PatientsRepository patientrepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ServicesService services;
	
	public Patients addPatient(Patients patient) {
		return patientrepo.save(patient);
	}
	
	public List<Patients> getAllPatients() {
		List<Patients> findAll = patientrepo.findAll();
		return findAll;
	}
	
	public Patients getPatientById(int id) {
		return patientrepo.findById(id).orElseThrow(()->new IllegalArgumentException("Patient Id not found"));
	}
	


//	public void addService(Services servi) {
//		// TODO Auto-generated method stub
//		String serviceUrl = "http://SERVICES-MS/service/addService";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Services> serviceEntity = new HttpEntity<>(servi,headers);
//		restTemplate.exchange(
//				serviceUrl,
//				HttpMethod.POST,
//				serviceEntity,
//				Services.class
//				);
//		
//	}
//	
//	public List<Services> getServices() {
//		String serviceUrl = "http://SERVICES-MS/service/all";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Void> serviceEntity = new HttpEntity<>(headers);
//		ResponseEntity<List<Services>> serviceinfo = restTemplate.exchange(
//				serviceUrl,
//				HttpMethod.GET,
//				serviceEntity,
//				new ParameterizedTypeReference<List<Services>>() {}
//				
//				);
//		return serviceinfo.getBody();
//	}
//	
//	public Services getServicebyId(int id){
//		String serviceUrl = "http://SERVICES-MS/service/"+id;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Void> serviceEntity = new HttpEntity<>(headers);
//		ResponseEntity<Services> serviceId = restTemplate.exchange(
//				serviceUrl,
//				HttpMethod.GET,
//				serviceEntity,
//				Services.class
//				);
//		return serviceId.getBody();
//	}
	
	public void addService(Services servi) {
		services.addService(servi);
	}
	
	public List<Services> getServices(){
		List<Services> allService = services.getAllService();
		return allService;
	}
	
	public Services getServicebyId(int id) {
		Services serviceById = services.getServiceById(id);
		return serviceById;
	}

}
