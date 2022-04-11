package com.cognixia.jump.jdbc.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDriver {

	public static void main(String[] args) {
		
		String URL = "jdbc:mysql://localhost:3306/university";
		String username = "root";
		String password = "admin";
		
		Connection connection = null;
		
		
		
		try {
			connection = DriverManager.getConnection(URL, username, password);
			Statement stmt = connection.createStatement();
			String query = "UPDATE student SET credits=100 WHERE student_id=10000";
			int count = stmt.executeUpdate(query);
			
			System.out.print("Modified "+ count + " records");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
