package com.example.demo.exception;

public class ErrorDetails {
	  private Integer status;
	  private String message;
	  public ErrorDetails(Integer status, String message) {
	    super();
	    this.status = status;
	    this.message = message;
	  }
	  public Integer getStatus() {
	    return status;
	  }

	  public String getMessage() {
	    return message;
	  }
	}
