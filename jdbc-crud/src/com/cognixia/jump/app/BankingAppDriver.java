package com.cognixia.jump.app;

import com.cognixia.jump.jdbc.dao.CustomerDAOClass;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.MainMenu;

public class BankingAppDriver {

	public static void main(String[] args) {
		System.out.println("Banking App Running...");
		
		//display Menu
		for(MainMenu option: MainMenu.values()) {
			System.out.println(option);
		}
		
		Customer cus1 = new Customer(0, "Mike", "mike@gmail.com", "mike123");
		
		CustomerDAOClass custDao = new CustomerDAOClass();
		System.out.print(custDao.createCustomer(cus1));
		
	}

}
