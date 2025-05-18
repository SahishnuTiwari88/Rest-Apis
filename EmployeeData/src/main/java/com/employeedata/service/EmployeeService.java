package com.employeedata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeedata.dao.EmployeeRepository;
import com.employeedata.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository emprep;
	
	public List<String> findHighestSalaryInEachDepartment(){
		return emprep.findDepartmentHavingHighestSalary();
	}
	
	public void addEmployee(Employee emp) {
		emprep.save(emp);
	}
	
	public Optional<String> getDepartmentWithLeastEmployees(){
		Pageable pageable = PageRequest.of(0,1);
		Page<String> result = emprep.findDepartmentWithLeastEmployees(pageable);
		return result.getContent().stream().findFirst();
	}
	
	public List<Employee> getEmployeeWorkingInMultipleDepartment(){
		return emprep.findEmployeeWorkForMultipleDepartments();
	}

}
