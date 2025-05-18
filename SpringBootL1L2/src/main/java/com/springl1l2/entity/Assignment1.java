package com.springl1l2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Assignment1 {
@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="bName")
	private String bName;
@Column(name="bAddress")
	private String bAddress;
	public Assignment1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assignment1(String bName, String bAddress) {
		super();
		this.bName = bName;
		this.bAddress = bAddress;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAddress() {
		return bAddress;
	}
	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}
	@Override
	public String toString() {
		return "Assignment1 [bName=" + bName + ", bAddress=" + bAddress + "]";
	}
	
	
	
	
}
