package com.EmployeeDataHandle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeDataHandle.entities.Department;
import com.EmployeeDataHandle.entities.Employee;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	 List<Department> findAll();
  
  List<Department> findByDname( String dname);
  
  //Department findByDname(String name);
 // Department add(Employee emp);
}
