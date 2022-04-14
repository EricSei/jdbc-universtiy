package com.cognixia.jump.app;

import java.util.Scanner;

import com.cognixia.jump.jdbc.dao.AuthDAO;
import com.cognixia.jump.jdbc.dao.CustomerDAOClass;
import com.cognixia.jump.jdbc.dao.DebitDAOClass;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.Debit;

//encapsulation of Customer, Account, Auth Controllers
public class Controllers {
	
	//Customer Controller
	public static class CustomerController{
		
		public static Customer createCustomer() {
			
			int id = 0;
			String name = "";
			String email = "";
			String password = "";
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name: ");
			name = sc.nextLine();
			System.out.println("Enter Eamil: ");
			email = sc.nextLine();
			System.out.println("Enter Password: ");
			password = sc.nextLine();
			
			Customer created = new Customer(id, name, email, password);
			CustomerDAOClass custDao = new CustomerDAOClass();
			if(custDao.createCustomer(created)) {
				return created;
			}
				
			return null;
			
		}
	}
	
	public static class AccountController{
		
		public static Account createAccount(int customerId) {	
			
			Debit acc1 = new Debit(customerId);
			DebitDAOClass debitDao = new DebitDAOClass();
			debitDao.createAccount(acc1);
			
			return null;
			
		}
	}
	
	public static class AuthController{
		
		public static Customer login() {
			
			
			int id = 0;
			String name = "";
			String email = "";
			String password = "";
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Eamil: ");
			email = sc.nextLine();
			System.out.println("Enter Password: ");
			password = sc.nextLine();
			
			Customer customer = new Customer(id, name, email, password);
			
			customer.setEmail(email);
			customer.setPassword(password);
			
			AuthDAO auth = new AuthDAO();
			customer = auth.login(customer);
			
			//null return
			return customer;
		}
	}
	
	
}
