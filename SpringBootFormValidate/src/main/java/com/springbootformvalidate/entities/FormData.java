package com.springbootformvalidate.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//import javax.validation.constraints.Email;


public class FormData {
     @NotBlank(message = "User name can not be empty")
     @Size(min = 3,max = 12,message = "User name must be between 3-12 characters")
	
     //now we have to trigger/handle these validation on controller by putting @Valid just before the data binding
     //(i.e. before @ModelAttribte
	private String username;
     
     @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "invalid email") //@Email
	private String email;
	
	public FormData(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public FormData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FormData [username=" + username + ", email=" + email + "]";
	}
}
