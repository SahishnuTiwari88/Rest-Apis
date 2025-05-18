package com.springl1l2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springl1l2.dao.Assignment5_Repository;
import com.springl1l2.entity.Assignment5;
@Service
public class Assignment5_Service {
	@Autowired
	private Assignment5_Repository resp;
	
	public List<Assignment5> getAllEmployees(){
		List<Assignment5> employees = resp.findAll();
		return employees;
	}
	
	public Assignment5 getEmployeeID(int eid) {
		Optional<Assignment5> emp = resp.findById(eid);
		Assignment5 employee = null;
		if(emp.isPresent()) {
			employee = emp.get();
		}
		return employee;
		
	}
	
	public void updateEmployee(Assignment5 assign) {
		resp.save(assign);
	}
	
	public void addEmployee(Assignment5 assin) {
		resp.save(assin);
	}
	
	public void deleteEmployeeById(Assignment5 assig) {
		resp.delete(assig);
	}
}
