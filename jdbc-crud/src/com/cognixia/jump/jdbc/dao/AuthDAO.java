package com.cognixia.jump.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.jdbc.connection.ConnectionManager;
import com.cognixia.jump.model.Customer;

public class AuthDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	
	//params: email, password
	public Customer login(Customer customer) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "Select email, password from customer \r\n"
				+ "    where customer.email = ? ";
		
		String storedEmail = null;
		String storedPassword = null;
		//query customer with email and check password
		try {
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, customer.getEmail());
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 storedEmail = rs.getString("email");
				 storedPassword = rs.getString("password");
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isExist =  customer.getEmail().equals(storedEmail) && 
				customer.getPassword().equals(storedPassword);
		if(isExist) {
			return customer;
		}
		
		return null;
	}
	
	public boolean logout() {
		return true;
	}
}
