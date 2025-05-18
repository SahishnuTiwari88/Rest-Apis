package com.springl1l2.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assignment5 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private String email;
	private String elocation;
	public Assignment5() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assignment5(int eid, String ename, String email, String elocation) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.elocation = elocation;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getElocation() {
		return elocation;
	}
	public void setElocation(String elocation) {
		this.elocation = elocation;
	}
	@Override
	public String toString() {
		return "Assignment5 [eid=" + eid + ", ename=" + ename + ", email=" + email + ", elocation=" + elocation + "]";
	}
	
	

}

