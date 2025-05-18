package com.employeedata.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeedata.entity.Employee;
import com.employeedata.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empserv;
	
	@PostMapping("/addemp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
		empserv.addEmployee(emp);
		return ResponseEntity.ok("saved successfully");
	}
	
	
	@GetMapping("/highest-salary-ineach-department")
	public ResponseEntity<List<String>> getDepartmentsHavingHighestSalary(){
		List<String> findHighestSalaryInEachDepartment = empserv.findHighestSalaryInEachDepartment();
		 return ResponseEntity.ok(findHighestSalaryInEachDepartment);
	}
	@GetMapping("/leastempdept")
	public String leastEmployeesDepartment() {
		Optional<String> department = empserv.getDepartmentWithLeastEmployees();
		return department.orElse("not found");
	}
	@GetMapping("/workformultidepart")
	public ResponseEntity<?> employeeWorkForMultipleDepartment(){
		Map<String,Object> Json = new LinkedHashMap<>();
		List<Employee> employee = empserv.getEmployeeWorkingInMultipleDepartment();
		Json.put("data", employee);
		return new ResponseEntity<>(Json,HttpStatus.OK);
	}

}
