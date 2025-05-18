package com.wipro.SA20449357.microservicesassignment1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String servicename;
	private float fees;
	@ManyToOne
	@JsonBackReference
	private Patients patient;
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Services(Long id, String servicename, float fees, Patients patient) {
		super();
		this.id = id;
		this.servicename = servicename;
		this.fees = fees;
		this.patient = patient;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public Patients getPatient() {
		return patient;
	}
	public void setPatient(Patients patient) {
		this.patient = patient;
	}
	
	

}
