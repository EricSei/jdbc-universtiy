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
	
	public static boolean isAuth = false;


	public static void main(String[] args) {
		
		
		System.out.println("Banking App Running...");
		
		Customer loggedCustomer = null;
		Customer created = null;
		
		int option = 0;
		
		do {
			
			if(!BankingAppDriver.isAuth) {
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
					BankingAppDriver.isAuth = true;
					System.out.println(created.toString());
					break;
				case 2:
					loggedCustomer = Controllers.AuthController.login();
					BankingAppDriver.isAuth = true;
					System.out.println(loggedCustomer.toString());
					System.out.println("You are logged in... ");
					break;
				case 3:
					Controllers.AccountController.createAccount(loggedCustomer.getCustomer_id());
					System.out.print("Accounted Created.");
				case 4:
					System.out.print("Make Deposit");
					if(Controllers.AccountController.makeDeposit()) {
						System.out.println("Deposit Successful.");
					}else {
						System.out.println("Deposit failed.");
					}
					break;
				case 5:
					System.out.println("-------------Last 5 Transactions-------------");
					break;
				case 10:
					System.out.println("You are logging out ! ");
					BankingAppDriver.isAuth = false;
					break;
				default:
					System.out.println("========Select A Menu to continue============");
			}
			
			
		}while(option != 10);
		

	}
	
	public static void getUserInput() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Option");
		
		String option = scanner.nextLine();
		System.out.print(option);
	}

}
