package com.employeedata.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeedata.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT e.department, MAX(e.salary) from Employee e Group By e.department")
	List<String> findDepartmentHavingHighestSalary();
	
	@Query("SELECT e.department from Employee e GROUP BY e.department ORDER BY COUNT(e.id) ASC")
	Page<String> findDepartmentWithLeastEmployees(Pageable pageable);
	
	//the above query can return more than one data that is why we have use Page concept because by
	//using pagination we can limit the number of data we want to get
//Page<String> it gives us information that the result will be paginated and page will contain result in string format
	
	//employee working for multiple departments
	
	@Query("SELECT e from Employee e where e.name IN("+
			"SELECT e1.name from Employee e1 Group By e1.name Having Count(e1.name)>1)")
	List<Employee> findEmployeeWorkForMultipleDepartments();
	
}
