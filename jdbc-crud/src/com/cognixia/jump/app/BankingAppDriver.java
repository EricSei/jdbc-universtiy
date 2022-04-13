package com.cognixia.jump.app;

import java.util.Scanner;

import com.cognixia.jump.jdbc.dao.AuthDAO;
import com.cognixia.jump.jdbc.dao.CustomerDAOClass;
import com.cognixia.jump.jdbc.dao.DebitDAOClass;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.Debit;
import com.cognixia.jump.model.MainMenu;

public class BankingAppDriver {
	


	public static void main(String[] args) {
		boolean isAuth = false;
		
		System.out.println("Banking App Running...");
		
		Customer loggedCustomer = null;
		Customer created = null;
		
		int option = 0;
		
		do {
			
			if(!isAuth) {
				System.out.println(Menu.displayLandingMenu());
			}else {
				System.out.println(Menu.displayAuthMenu());
			}
			
			option = Menu.getUserInput();
			System.out.println(option + "is selected loading ...\n");
			
			//Navigation
			switch(option) {
				case 1:
					created = Controllers.CustomerController.createCustomer();
					isAuth = true;
					System.out.println(created.toString());
					break;
				case 2:
					loggedCustomer = Controllers.AuthController.login();
					isAuth = true;
					System.out.println(loggedCustomer.toString());
					System.out.println("You are logged in... ");
					break;
				default:
					System.out.println("Thanks for using Banking App");
			}
			
			
		}while(option != 10);
		
		System.out.println("Thanks for using Baniking App ... :) ");
	}
	
	public static void getUserInput() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Option");
		
		String option = scanner.nextLine();
		System.out.print(option);
	}

}
