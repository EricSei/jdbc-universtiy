package com.cognixia.jump.model;

public class Saving extends Account {
	
	@Override
	public boolean deposit(int amount) {
		
		return false;
	}

	@Override
	public boolean withDraw(int amount) {
		
		return false;
	}

	@Override
	public boolean fundTransfer(int amount, Account to) {
		
		return false;
	}

}
