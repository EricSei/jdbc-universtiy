package com.cognixia.jump.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.jdbc.connection.ConnectionManager;
import com.cognixia.jump.model.Transaction;

public class TransactionDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	
	public static void main(String[] args) {
//		Transaction created = new Transaction("withdraw 100", 2);
//		
//		boolean flag = new TransactionDAO().createTransaction(created);
//		System.out.println(flag);
		
		List<Transaction> transactions = new TransactionDAO().transactionByAccountId(2);
		transactions.forEach(n -> System.out.println(n.getDescription() ));
	}
	
	public List<Transaction> transactionByAccountId(int accountId) {
		
		String query = "select * from Transaction where account_id = ?";
		
		ResultSet rs = null;
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, accountId);
			rs = pstmt.executeQuery();
			List<Transaction> transactions = new ArrayList<>();
			
			while(rs.next()) {
				Transaction ts = new Transaction( 
						rs.getInt("transaction_id"),
						rs.getString("description"),
						rs.getString("date"),
						rs.getInt("account_id")
					);
				transactions.add(ts);
				
			}
			return transactions;
			
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
		
		
		return null;
	}
	
	public boolean createTransaction(Transaction transaction) {
		
		String query = "INSERT INTO Transaction(transaction_id, description, date, account_id)"
				+"values(?, ?, ?, ? )";
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, transaction.getDescription());
			pstmt.setString(3,  transaction.getDate().toString());
			pstmt.setInt(4, transaction.getAccount_id());
			
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
