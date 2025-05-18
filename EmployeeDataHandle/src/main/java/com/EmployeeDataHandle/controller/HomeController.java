package com.EmployeeDataHandle.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeDataHandle.entities.Employee;
import com.EmployeeDataHandle.service.DepartmentService;
import com.EmployeeDataHandle.service.EmployeeService;

@RestController
public class HomeController {
	@Autowired
	private EmployeeService empserv;
	private DepartmentService depser;
	
	Map<String,Object>Json = new LinkedHashMap<String,Object>();
	
	@PostMapping("/addemp")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		Employee addEmployee = empserv.addEmployee(employee);
		Json.put("data", addEmployee);
		return new ResponseEntity<>(Json,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/highestsalary")
	public ResponseEntity<?> getEmployeesWithHighestSalaryInEachDepartment(){
		Map<String, Employee> employeeWithHighestSalaryByDepartment = empserv.getEmployeeWithHighestSalaryByDepartment();
		 Json.put("data", employeeWithHighestSalaryByDepartment);
		 return new ResponseEntity<>(Json,HttpStatus.OK);
	}
	@GetMapping("/{dname}")
	public ResponseEntity<?> getEmployeesByDepartment(@PathVariable("dname") String dname){
		 List<Employee> employee = empserv.getEmployeeByDname(dname);

		 return ResponseEntity.ok(employee);
		
	}
	@GetMapping("/difdepart")
	public ResponseEntity<?> getEmployeeWorkingInDifferentDepartment(){
		List<Employee> workingInDifDepart = empserv.getEmployeeWorkingInMultipleDepartments();
		return ResponseEntity.ok(workingInDifDepart);
	}
	
	@GetMapping
	public ResponseEntity<?> getInvalidField(){
		Json.put("msg", "Invalid field has been passed");
		return new ResponseEntity<>(Json,HttpStatus.BAD_REQUEST);
	}
	

}
