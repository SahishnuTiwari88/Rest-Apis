package com.springl1l2.controller;

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

import com.springl1l2.entity.Assignment5;
import com.springl1l2.service.Assignment5_Service;

@RestController
public class Assignment5_Controller {
	@Autowired
	private Assignment5_Service serv;

	Map<Integer, Assignment5> Mapping = new LinkedHashMap<>();

	@GetMapping("/employees")
	public ResponseEntity<?> getEmployees() {
		List<Assignment5> employees = serv.getAllEmployees();
		if (employees.isEmpty()) {
//			Mapping.put("status", 0);
//			Mapping.put("message", "No employees are found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
//			Mapping.put("status", 1);
//			Mapping.put("data", employees);
			return new ResponseEntity<>(employees, HttpStatus.OK);
		}
	}

	 //@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/addemp")
	public ResponseEntity<?> insertEmployee(@RequestBody Assignment5 assign) {
		if (Mapping.containsKey(assign.getEid())) {
//			Mapping.put("status", 0);
//			Mapping.put("message", "ID already available or ID Conflict");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			serv.addEmployee(assign);
//			Mapping.put("status", 1);
			Mapping.put(assign.getEid(), assign);
			return new ResponseEntity<>(Mapping, HttpStatus.CREATED);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmpById(@PathVariable("id") int eid) {
		Assignment5 employee = serv.getEmployeeID(eid);
		if (employee != null) {
//			Mapping.put("status", 1);
//			Mapping.put("data", employee);
			return new ResponseEntity<>(employee,HttpStatus.OK);
		} 
		else {
			//Mapping.put("status", 0);
			//Mapping.put("message", "No employees with given id found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmpId(@PathVariable("id") int eid) {
		Assignment5 employ = serv.getEmployeeID(eid);
		serv.deleteEmployeeById(employ);
		//Mapping.put("status", 1);
		//Mapping.put("message", "Employee with given id deleted successfully");
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmpById(@RequestBody Assignment5 assign,@PathVariable("id")int eid){
		
		Assignment5 emp = serv.getEmployeeID(eid);
		if(emp!=null) {
		emp.setEid(assign.getEid());
		emp.setEname(assign.getEname());
		emp.setEmail(assign.getEmail());
		emp.setElocation(assign.getElocation());
		serv.updateEmployee(emp);
		//Mapping.put("status", 1);
		//Mapping.put("message", "Employee data update successfully for given id");
		return new ResponseEntity<>(emp,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
	}


