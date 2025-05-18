package com.springl1l2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springl1l2.dao.Assignment4_Repository;
import com.springl1l2.entity.Assignment4;

@Service
public class Assignment4_Service {
	@Autowired
	private Assignment4_Repository assignrep;
	
	public void addEmployee(Assignment4 assign) {
		assignrep.save(assign);
	}
	
	public List<Assignment4> getAllEmployees(){
		List<Assignment4> empList = assignrep.findAll();
		return empList;
	}
	
	public Assignment4 getEmployeeById(int id) {
		Optional<Assignment4> emp = assignrep.findById(id);
		Assignment4 employee =null;
		if(emp.isPresent()) {
			employee = emp.get();
		}
		return employee;
	}

}
