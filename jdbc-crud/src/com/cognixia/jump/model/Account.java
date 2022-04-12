package com.cognixia.jump.model;

public interface Account {
	
	int balance=0;
	
	boolean deposit(int amount);
	
	boolean withDraw(int amount);
	
	boolean fundTransfer(int amount, Account to);
	
}
