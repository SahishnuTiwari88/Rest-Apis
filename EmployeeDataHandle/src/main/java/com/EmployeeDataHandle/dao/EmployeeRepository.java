package com.EmployeeDataHandle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeDataHandle.entities.Department;
import com.EmployeeDataHandle.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//	List<Employee> findGroupByDepartmentOrderBySalaryDesc(Department department);
	List<Employee> findByDepartments(Department department);
	List<Employee> findTopByDepartmentsOrderBySalaryDesc(Department department);
	//List<Employee> findByDepartmentIsNotEmpty();
	//it will generate query automatically on basis of criteria Api, It retrives all employee whose collection
	//of departments is not empty
	
	
	
	

}
