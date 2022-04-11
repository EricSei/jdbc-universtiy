package com.cognixia.jump.app;

import com.cognixia.jump.model.MainMenu;

public class BankingAppDriver {

	public static void main(String[] args) {
		System.out.println("Banking App Running...");
		
		//display Menu
		for(MainMenu option: MainMenu.values()) {
			System.out.println(option);
		}
		

	}

}
