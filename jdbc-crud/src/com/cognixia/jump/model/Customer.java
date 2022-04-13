package com.cognixia.jump.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	

	private int customer_id;
	private String name;
	
	private String email;
	
	private List<Account> accounts;
	
	private String password;
	
	public Customer(int customer_id, String name, String email, String password) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.email = email;
		this.accounts = new ArrayList<Account>();
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", email=" + email + ", accounts=" + accounts
				+ ", password=" + password + "]";
	}
	
	

}
