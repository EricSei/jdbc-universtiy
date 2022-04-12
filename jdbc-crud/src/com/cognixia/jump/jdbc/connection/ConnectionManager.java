package com.cognixia.jump.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static Connection connection = null;
	private static final String URL = "jdbc:mysql://localhost:3306/banking";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
			
	private ConnectionManager() {
		
	}
	
	private static void makeConnection() {
		try {
			connection  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			makeConnection();
		}
		
		return connection;
	}
	
	
	

}
