package com.cognixia.jump.model;

import java.util.Date;

public class Transaction {
	
	private String description;
	
	private Date date;

	public Transaction(String description, Date date) {
		super();
		this.description = description;
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
