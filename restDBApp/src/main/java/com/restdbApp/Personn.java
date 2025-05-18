package com.restdbApp;

import jakarta.persistence.*;

//import org.springframework.stereotype.Component;
//
//@Component
//public class Personn {
//
//	private int pid;
//	private String pname;
//	public Personn() {
//		
//	}
//	public Personn(int pid, String pname) {
//		super();
//		this.pid = pid;
//		this.pname = pname;
//	}
//	public int getPid() {
//		return pid;
//	}
//	public void setPid(int pid) {
//		this.pid = pid;
//	}
//	public String getPname() {
//		return pname;
//	}
//	public void setPname(String pname) {
//		this.pname = pname;
//	}
	
//}
@Entity
@javax.xml.bind.annotation.XmlRootElement(name="personn")
@Table(name="Personn")
public class Personn{
@Id
@Column(name="pid")
	private int pid;
@Column(name="pname")	
	private String pname;
@Column(name="pjob")	
	private String pjob;

	public Personn() {
		
	}

	public Personn(int pid, String pname, String pjob) {
		
		this.pid = pid;
		this.pname = pname;
		this.pjob = pjob;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPjob() {
		return pjob;
	}

	public void setPjob(String pjob) {
		this.pjob = pjob;
	}
	
}
