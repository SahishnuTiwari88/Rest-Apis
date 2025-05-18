package com.springl1l2.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springl1l2.entity.Assignment1;
import com.springl1l2.service.Assignment1_Service;

@RestController
public class Assignment1_Controller {
	@Autowired
	private Assignment1_Service assinserv;
	
	@GetMapping("/bank/name")
	public ResponseEntity<?> getAllBankName(){
		Map<String,Object> JsonOutput = new HashMap<>();
		List<Assignment1> allBankName = assinserv.getAllBankName();
		//to find all bank name
		List<String> bankName = allBankName.stream()
				.map(Assignment1::getbName)
				.collect(Collectors.toList());

			
			JsonOutput.put("status", 1);
			JsonOutput.put("message", "Available banks");
			JsonOutput.put("data",bankName);
			return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
		}
	
	
	@GetMapping("/bank/address")
	public ResponseEntity<?> getAllBankAddress(){
		Map<String,Object> JsonOutput = new HashMap<>();
		List<Assignment1> allBankaddress = assinserv.getAllBankName();
		List<String> bankAddress = allBankaddress.stream()
				.map(Assignment1::getbAddress)
				.collect(Collectors.toList());

			JsonOutput.put("status", 1);
			JsonOutput.put("message", "Available banks address");
			JsonOutput.put("data",bankAddress);
			return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
		}
	
	@PostMapping("/addbank")
	public ResponseEntity<?> addBank(@RequestBody Assignment1 assign){
		Map<String,Object> JsonOutput = new HashMap<>();
		assinserv.addBank(assign);
		JsonOutput.put("status", 1);
		JsonOutput.put("message", "Injected successfully");
		return new ResponseEntity<>(JsonOutput,HttpStatus.ACCEPTED)	;	
		
	}

}
