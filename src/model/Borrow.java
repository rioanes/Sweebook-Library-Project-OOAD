package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.*;
import java.util.*;

public class Borrow {
	private String id;
	private String memberId;
	private String status;
	private String borrowTimestamp;
	
	final String insertString = "INSERT INTO borrow (id,memberId, status, borrowTimestamp) VALUES (?, ?, ?, ?);";
    final String updateString = "UPDATE borrow SET status=?, WHERE id=? ;";
    final String findIdString = "SELECT * FROM borrow WHERE id=? ;";
    
    
	//constructor
	public Borrow() {
		super();
	}
	
	public Borrow(String id, String memberId, String status, String borrowTimestamp) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.status = status;
		this.borrowTimestamp = borrowTimestamp;
	}
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBorrowTimestamp() {
		return borrowTimestamp;
	}
	public void setBorrowTimestamp(String borrowTimestamp) {
		this.borrowTimestamp = borrowTimestamp;
	}
	
	public Borrow find(String id) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		Borrow borrow = new Borrow();
		try {
			statement = connection.prepareStatement(findIdString);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(); //gtw butuh kasi findString ato ga
			
			borrow.setId(rs.getString("id"));
			borrow.setMemberId(rs.getString("memberId"));
			borrow.setStatus(rs.getString("status"));
			borrow.setBorrowTimestamp(rs.getString("borrowTimestamp"));
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return borrow;
	}
	
	public Borrow insert() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertString);
			statement.setString(1, this.id);
			statement.setString(2, this.memberId);
			statement.setString(3, this.status);
			statement.setString(4, this.borrowTimestamp);
			
			statement.executeUpdate();
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return this;
	}
	
	public Borrow update() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(updateString);
			statement.setString(1, this.status);
			statement.setString(2, this.id);

			
			statement.executeUpdate();
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return this;
	}
	
	public boolean isBookStillBorrowing(String userId, String bookId) {
		
	}
	
	public int getCountBookStillBorrowing(String userId) {
		
	}
	
	public List<Borrow> getPendingStatus(boolean isOnlyCurrentMember) {
		
	}
	
	public List<Borrow> getAcceptStatus(Date date, boolean isOnlyCurrentMember){
		
	}
}
