package com.wipro.capstone.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.entity.Customer;
import com.wipro.capstone.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService custserv;

	@GetMapping("/getcustomers")
	public ResponseEntity<?> getCustomers() {
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		List<Customer> list = custserv.getAllCustomers();
		if (!list.isEmpty()) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			JsonOutput.put("status",1);
			JsonOutput.put("data", list);
			return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
			}
		//return ResponseEntity.of(Optional.of(list));
		else {
			JsonOutput.clear();
			JsonOutput.put("status", 0);
			JsonOutput.put("data", "Data not found");
			return new ResponseEntity<>(JsonOutput,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/savecustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer cust){
		Map<String, Object> JsonOutput = new LinkedHashMap<String, Object>();
		Customer addCustomer = custserv.addCustomer(cust);
		JsonOutput.put("status", 1);
		JsonOutput.put("message", "Record Inserted Successfully");
		JsonOutput.put("data",addCustomer );
		return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int custId){
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		Customer custo = custserv.getCustomerById(custId);
		if(custo!=null) {
			//JsonOutput.put("status",1);
			JsonOutput.put("data",custo);
			return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
		}else {
			JsonOutput.clear();
			//JsonOutput.put("status", 0);
			JsonOutput.put("data", "Data not found");
			return new ResponseEntity<>(JsonOutput,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int custId){
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		Customer customer = custserv.getCustomerById(custId);
		custserv.deleteCustomerById(customer);
		JsonOutput.put("status",1);
		JsonOutput.put("message", "Deleted successfully");
		return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@RequestBody Customer custom, @PathVariable("id") int custId){
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		
		Customer customer = custserv.getCustomerById(custId);
		//System.out.println(custserv.get);
		customer.setCustId(custom.getCustId());
		customer.setCustName(custom.getCustName());
		customer.setCustAddress(custom.getCustAddress());
		customer.setBankaccount(custom.getBankaccount());
		custserv.addCustomer(customer);
		JsonOutput.put("status",1);
		JsonOutput.put("data", custserv.getCustomerById(custId));
		return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
		
		
		}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<?> deleteAllCustomers(){
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		List<Customer> list = custserv.getAllCustomers();
		if(!list.isEmpty()) {
			custserv.delete();
			JsonOutput.put("status", 1);
			JsonOutput.put("message", "All customers deleted successfully");
			return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
		}
		else {
			JsonOutput.clear();
			JsonOutput.put("status", 0);
			JsonOutput.put("message", "No data available to delete");
			return new ResponseEntity<>(JsonOutput,HttpStatus.NOT_FOUND);
		}
		}

}
