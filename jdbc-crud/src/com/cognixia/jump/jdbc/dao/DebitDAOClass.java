package com.cognixia.jump.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognixia.jump.jdbc.connection.ConnectionManager;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.Debit;

public class DebitDAOClass {
	
	private Connection conn = ConnectionManager.getConnection();
	
	public  boolean createAccount(Debit debit) {
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Account(account_id, balance, type, customer_id) "
				+ "values( ?, ?, ?, ?)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, debit.getBalance() );
			pstmt.setString(3,  debit.getType());
			pstmt.setInt(4,  debit.getCustomer_id());
			
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
