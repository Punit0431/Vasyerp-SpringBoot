package com.example.demo.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String messeage;
	private String details;
	public ErrorDetails(Date timestamp, String messeage, String details) {
		super();
		this.timestamp = timestamp;
		this.messeage = messeage;
		this.details = details;
	}
	
	public ErrorDetails() {
		super();
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMesseage() {
		return messeage;
	}
	public void setMesseage(String messeage) {
		this.messeage = messeage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
}
