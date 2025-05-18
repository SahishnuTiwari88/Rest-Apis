package com.EmployeeDataHandle.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String number;
	private String address;
	private double salary;
	@ManyToMany(cascade = CascadeType.ALL)
	//@JsonIgnoreProperties("employees")
	@JoinTable(name = "employee_department",
	joinColumns = @JoinColumn(name="employee_id"),
	inverseJoinColumns =@JoinColumn(name="department_id"))
	private List<Department> departments ;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String number, String address, double salary, List<Department> departments) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.address = address;
		this.salary = salary;
		this.departments = departments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
	
}
