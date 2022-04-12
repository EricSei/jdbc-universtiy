package com.cognixia.jump.model;

import java.util.List;

public class Debit implements Account {
	
	private int balance=0;
	
	private List<Transaction> transactions = null;
	
	public Debit() {
		this.balance = 5000;
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

}
