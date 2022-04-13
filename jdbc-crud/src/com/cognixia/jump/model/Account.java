package com.cognixia.jump.model;

public abstract class Account {
	
	int accountId;
	
	int balance;
	
	String type;
	
	abstract boolean deposit(int amount);
	
	abstract boolean withDraw(int amount);
	
	abstract boolean fundTransfer(int amount, Account to);
	
	
}
