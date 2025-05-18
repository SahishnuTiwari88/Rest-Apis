package com.EmployeeDataHandle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeDataHandle.dao.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository deprep;
	
//	public List<Employee> getEmployeesWithHighestSalaryInEachDepartment(){
//		//emprep.findByDepartmentOrderBySalaryDesc(null)
//		List<Employee> employees = new ArrayList<>();
//		List<Department>departments = deprep.findAll();
//		for(Department department : departments) {
//			List<Employee> employeesInDepartment = deprep.findGroupByDepartmentOrderBySalaryDesc(department);
//			if(!employeesInDepartment.isEmpty()) {
//				employees.add(employeesInDepartment.get(0));
//			}
//		}
//		return employees;
//	}

}
