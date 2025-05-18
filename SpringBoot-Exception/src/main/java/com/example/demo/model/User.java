package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_TBL")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String userName;
  private String mobileNo;
  private String emailId;
  private String city;
  private String password;
public User() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}  
}
