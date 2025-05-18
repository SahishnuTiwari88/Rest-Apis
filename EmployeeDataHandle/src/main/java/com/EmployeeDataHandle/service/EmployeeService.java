package com.EmployeeDataHandle.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeDataHandle.dao.DepartmentRepository;
import com.EmployeeDataHandle.dao.EmployeeRepository;
import com.EmployeeDataHandle.entities.Department;
import com.EmployeeDataHandle.entities.Employee;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository emprep;
	@Autowired
	private DepartmentRepository departrep;

	
	
	public EmployeeService(EmployeeRepository emprep, DepartmentRepository departrep) {
		super();
		this.emprep = emprep;
		this.departrep = departrep;
	}

	//save date to database
	

	
	public Employee addEmployee(Employee emp) {
        List<Department> departments = emp.getDepartments();
        if (departments != null && !departments.isEmpty()) {
            List<Department> updatedDepartments = new ArrayList<>();
            for (Department department : departments) {
                List<Department> existingDepartments = departrep.findByDname(department.getDname());
                if (!existingDepartments.isEmpty()) {
                    Department existingDepartment = existingDepartments.get(0);
                    //if department is already exist it will add new employee to that department if there department is same
                    existingDepartment.getEmployees().add(emp);
                    updatedDepartments.add(existingDepartment);
                } else {
                	//if department is not present, new department will be created and employee data added to it
                    department.getEmployees().add(emp);
                    updatedDepartments.add(department);
                }
            }
            emp.setDepartments(updatedDepartments);
        }
        return emprep.save(emp);
    }
	
	//employee having highest salary in department

	public Map<String, Employee> getEmployeeWithHighestSalaryByDepartment(){
		
		List<Department> departments = departrep.findAll();
		
		Map<String,Employee> emp= new LinkedHashMap<>();
		for(Department depart:departments) {
			List<Employee> salarybyDepart = emprep.findTopByDepartmentsOrderBySalaryDesc(depart);
			if(!salarybyDepart.isEmpty()) {
				emp.put(depart.getDname(), salarybyDepart.get(0));
				
			}
			
			}
		return emp;
	}
	
	
	//employee in particular department
	
	public List<Employee> getEmployeeByDname(String departname){

		List<Employee> employee=new ArrayList<>();
		 List<Department> departments = departrep.findByDname(departname);
		for(Department depart:departments) {
			if(departname.equals(depart.getDname())) {
				
			 List<Employee> emp = emprep.findByDepartments(depart);
			 if(!emp.isEmpty()) {
				 employee.addAll(emp);
			 }
			}

		}
		
		return employee;
		
	}
	
	//employee working in multiple departments
	
	public List<Employee> getEmployeeWorkingInMultipleDepartments(){
		
		List<Employee> empInMultiDepart = new ArrayList<>();
		List<Employee> employees = emprep.findAll();
		for(Employee emp:employees) {
			if(emp.getDepartments().size()>1) {
				empInMultiDepart.add(emp);
			}
		}
		return empInMultiDepart;
		
	}
	

	
}
