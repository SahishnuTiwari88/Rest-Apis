package com.tokengenerate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Desk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,unique=true)
	private  String deskNo;
	@Column(nullable=false)
	public int currentCapacity;
	private boolean status;
	public Desk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Desk(Long id, String deskNo, int currentCapacity, boolean status) {
		super();
		this.id = id;
		this.deskNo = deskNo;
		this.currentCapacity = currentCapacity;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeskNo() {
		return deskNo;
	}
	public void setDeskNo(String deskNo) {
		this.deskNo = deskNo;
	}
	public int getCurrentCapacity() {
		return currentCapacity;
	}
	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}