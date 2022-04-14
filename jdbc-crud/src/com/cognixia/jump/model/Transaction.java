package com.cognixia.jump.model;

import java.time.LocalDate;

public class Transaction {
	
	private int transaction_id;
	private String description;
	
	private String date; //use LocalDate.now().toString()
	
	private int account_id;
	
	public Transaction(String description, int account_id) {
		super();
		this.transaction_id = 0;
		this.description = description;
		this.date = LocalDate.now().toString();
		this.account_id = account_id;
	}
	
	
	
	public Transaction(int transaction_id, String description, String date, int account_id) {
		super();
		this.transaction_id = transaction_id;
		this.description = description;
		this.date = date;
		this.account_id = account_id;
	}



	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
