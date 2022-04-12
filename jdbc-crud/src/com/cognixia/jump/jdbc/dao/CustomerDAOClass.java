package com.cognixia.jump.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognixia.jump.jdbc.connection.ConnectionManager;
import com.cognixia.jump.model.Customer;



public class CustomerDAOClass implements CustomerDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public boolean createCustomer(Customer customer) {
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Customer(customer_id, name, email, password) "
				+ "values( ?, ?, ?, ?)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setString(2, customer.getName() );
			pstmt.setString(3,  customer.getEmail());
			pstmt.setString(4,  customer.getPassword());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result > 0;
		
	}

}


