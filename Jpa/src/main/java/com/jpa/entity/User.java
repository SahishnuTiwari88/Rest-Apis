package com.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String ucity;
	private String ustatus;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String ucity, String ustatus) {
		super();
		this.id = id;
		this.name = name;
		this.ucity = ucity;
		this.ustatus = ustatus;
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
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", ucity=" + ucity + ", ustatus=" + ustatus + "]";
	}
	
}
