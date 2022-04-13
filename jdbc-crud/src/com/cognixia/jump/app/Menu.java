package com.cognixia.jump.app;

import java.util.Scanner;

public class Menu {
	
	public static int getUserInput() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Option");
		
		String option = scanner.nextLine();
		return Integer.parseInt(option);
	}
	
	public static String displayLandingMenu() {
		
		String menu = "-----------Menu-----------\n"
				+" 1. Create User Account \n"
				+" 2. Login User Account \n"
				+" 10. Exit \n"
				;
		
	
		return menu;
	}
	
	public static String displayAuthMenu() {
		
		String menu = "-----------Menu-----------\n"
				+" 3. Create a Bank Account  \n"
				+" 4. Make Deposit  \n"
				+" 5. Display Your Account Information \n"
				+" 10. Exit \n"
				;
		
		return menu;
	}
}
