package com.model;

public class GenerateTokenRequestDTO {
	

	private Long customerId;
	private Long deskId;
	public GenerateTokenRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getDeskId() {
		return deskId;
	}
	public void setDeskId(Long deskId) {
		this.deskId = deskId;
	}
	
}
