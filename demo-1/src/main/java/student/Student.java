package student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
@javax.xml.bind.annotation.XmlRootElement(name="student")
@Table(name="Student")
public class Student{
@Id
@Column(name="sid")
	private int sid;
@Column(name="sname")	
	private String sname;
@Column(name="scourse")	
	private String scourse;

	public Student() {
		
	}

	public Student(int sid, String sname, String scourse ) {
		
		this.sid = sid;
		this.sname = sname;
		this.scourse = scourse;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getScourse() {
		return scourse;
	}

	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	
}
