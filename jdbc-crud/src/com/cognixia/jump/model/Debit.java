package com.cognixia.jump.model;

import java.util.ArrayList;
import java.util.List;

public class Debit extends Account {
	
	private int account_id;
	private int balance;
	private String type;
	
	private int customer_id;
	
	private List<Transaction> transactions = null;
	
	
	public Debit(int customer_id) {
		this.setAccount_id(0);
		this.balance = 5000;
		this.type = "DEBIT";
		this.setCustomer_id(customer_id);
		this.transactions = new ArrayList<>();
		
	}
	public Debit(int balance, List<Transaction> transactions) {
		super();
		this.balance = balance;
		this.transactions = transactions;
	}

	//send only most recent 5
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public boolean deposit(int amount) {
		
		if(amount > 0) {
			this.setBalance(amount);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean withDraw(int amount) {
		
		if(amount >= balance) {
			int balance = this.balance - amount;
			this.setBalance(balance);
			return true;
		}
		return false;
	}
	


	@Override
	public boolean fundTransfer(int amount, Account to) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getType() {
		return type;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

}
