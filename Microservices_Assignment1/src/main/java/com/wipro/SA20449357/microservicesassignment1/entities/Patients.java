package com.wipro.SA20449357.microservicesassignment1.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Patients {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Services> services;
	public Patients() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patients(Long id, String firstname, String lastname, List<Services> services) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.services = services;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	}
	
	
	
}
