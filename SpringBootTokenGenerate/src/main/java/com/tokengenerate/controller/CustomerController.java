package com.tokengenerate.controller;

import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tokengenerate.dao.CustomerRepository;

import com.tokengenerate.entity.Customer;

@RestController
//@RequestMapping("/customer")
public class CustomerController {
	private CustomerRepository custrep;
	

	public CustomerController(CustomerRepository custrep) {
		super();
		this.custrep = custrep;
	}
	
	@PostMapping("/enroll")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer cust){
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		if(cust.getName()==null && cust.getMobileNumber()==null) {
			JsonOutput.put("status", -1);
			JsonOutput.put("message", "No information related to customer exists");
			return new ResponseEntity<>(JsonOutput,HttpStatus.BAD_REQUEST);
			}
		if(custrep.existsByMobileNumber(cust.getMobileNumber())) {
			JsonOutput.put("status", 0);
			JsonOutput.put("message", "Mobile number already exist");
			return new ResponseEntity<>(JsonOutput,HttpStatus.ALREADY_REPORTED);
		}
		
		
		
		Customer customer=custrep.save(cust);
		
		JsonOutput.put("status", 1);
		JsonOutput.put("message", "Customer Enrolled successfully");
		JsonOutput.put("data", customer);
		return new ResponseEntity<>(JsonOutput,HttpStatus.ACCEPTED);
		
	}
	

}
