package com.tokengenerate.entity;

public class Desk_Status {
	private String deskNumber;
	private String deskStatus;
	public Desk_Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Desk_Status(String deskNumber, String deskStatus) {
		super();
		this.deskNumber = deskNumber;
		this.deskStatus = deskStatus;
	}
	public String getDeskNumber() {
		return deskNumber;
	}
	public void setDeskNumber(String deskNumber) {
		this.deskNumber = deskNumber;
	}
	public String getDeskStatus() {
		return deskStatus;
	}
	public void setDeskStatus(String deskStatus) {
		this.deskStatus = deskStatus;
	}
	
	

}
