package com.tokengenerate.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String tokenNumber;
	@Column(nullable=false)
	private String deskNumber;
	@Column(nullable=false)
	private String customerMobileNumber;
	@Column(nullable=false)
	private String primaryAccount;
	@Column(nullable=false)
	private int numberOfPersonsBefore;
	@Column(nullable=false)
	private LocalDateTime dateTime;
	@Column(nullable=false)
	private String requestAccepted;
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Token(Long id, String tokenNumber, String deskNumber, String customerMobileNumber, String primaryAccount,
			int numberOfPersonsBefore, LocalDateTime dateTime, String requestAccepted) {
		super();
		this.id = id;
		this.tokenNumber = tokenNumber;
		this.deskNumber = deskNumber;
		this.customerMobileNumber = customerMobileNumber;
		this.primaryAccount = primaryAccount;
		this.numberOfPersonsBefore = numberOfPersonsBefore;
		this.dateTime = dateTime;
		this.requestAccepted = requestAccepted;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTokenNumber() {
		return tokenNumber;
	}
	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
	public String getDeskNumber() {
		return deskNumber;
	}
	public void setDeskNumber(String deskNumber) {
		this.deskNumber = deskNumber;
	}
	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}
	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}
	public String getPrimaryAccount() {
		return primaryAccount;
	}
	public void setPrimaryAccount(String primaryAccount) {
		this.primaryAccount = primaryAccount;
	}
	public int getNumberOfPersonsBefore() {
		return numberOfPersonsBefore;
	}
	public void setNumberOfPersonsBefore(int numberOfPersonsBefore) {
		this.numberOfPersonsBefore = numberOfPersonsBefore;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getRequestAccepted() {
		return requestAccepted;
	}
	public void setRequestAccepted(String requestAccepted) {
		this.requestAccepted = requestAccepted;
	}
	
}
