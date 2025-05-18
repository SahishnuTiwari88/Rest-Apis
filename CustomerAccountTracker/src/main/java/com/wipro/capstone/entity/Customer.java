package com.wipro.capstone.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String custName;
	private String custAddress;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<BankAccount> bankaccount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Customer(int custId, String custName, String custAddress, List<BankAccount> bankaccount) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.bankaccount = bankaccount;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public List<BankAccount> getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(List<BankAccount> bankaccount) {
		this.bankaccount = bankaccount;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", bankaccount=" + bankaccount + "]";
	}
	
	
	
	

}
