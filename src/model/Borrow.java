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
	
	final String insertString = "INSERT INTO borrows (id,member_id, status, borrowTimestamp) VALUES (?, ?, ?, ?);";
    final String updateString = "UPDATE borrows SET status=?, WHERE id=? ;";
    final String findIdString = "SELECT * FROM borrows WHERE id=? ;";
    final String countBookString = "SELECT COUNT(*) " + 
    		"FROM borrow_items JOIN borrows " +
    		"ON borrow_items.borrow_id = borrows.id " + 
    		"WHERE borrows.id = ? AND borrows.member_id = ? ";
    final String isStillBorrowString =
    		"SELECT COUNT(*) " + 
    		"FROM borrow_items JOIN borrows " +
    		"ON borrow_items.borrow_id = borrows.id" + 
    		"WHERE borrows.id = ? AND borrows.member_id = ? AND borrow_items.book_id = ?";
    
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
		
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		
		boolean result = false;
		try {
			statement = connection.prepareStatement(isStillBorrowString);
			statement.setString(1, id);
			statement.setString(2, userId);
			statement.setString(3, bookId);
			ResultSet rs = statement.executeQuery(); 
			
			if(rs.getInt(1) > 0)
				result = true;
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public int getCountBookStillBorrowing(String userId) {
		
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		
		int count = 0;
		
		try {
			statement = connection.prepareStatement(isStillBorrowString);
			statement.setString(1, id);
			statement.setString(2, userId);
			ResultSet rs = statement.executeQuery(); 
			
			count = rs.getInt(1);
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return count;
	}
	
	public List<Borrow> getPendingStatus(boolean isOnlyCurrentMember) {
		//isOnlyCurrentMember = where member_id = User.id
		String query = "SELECT * FROM `borrows` "
				+ "WHERE `status` = 'pending' ";
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		
		List<Borrow> borrows = new ArrayList<Borrow>();
		try {
			if(isOnlyCurrentMember) {
				query += "member_id = ?";
				statement = connection.prepareStatement(query);
				statement.setString(1, memberId);
			}
			
			ResultSet rs = statement.executeQuery(); 
			
			while(rs.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(rs.getString(1));
				borrow.setMemberId(rs.getString(2));
				borrow.setStatus(rs.getString(3));
				borrow.setBorrowTimestamp(rs.getTimestamp(4).toString());
				
				borrows.add(borrow);
			}
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return borrows;
	}
	
	public List<Borrow> getAcceptStatus(Date date, boolean isOnlyCurrentMember){
		String query = "SELECT * FROM `borrows` "
				+ "WHERE MONTH = ? AND YEAR = ? AND `status` = 'accept' ";
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		
		List<Borrow> borrows = new ArrayList<Borrow>();
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, date.getMonth());
			statement.setInt(2, date.getYear());
			
			if(isOnlyCurrentMember) {
				query += "member_id = ?";
				
				statement.setString(3, memberId);
			}
			
			ResultSet rs = statement.executeQuery(); 
			
			while(rs.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(rs.getString(1));
				borrow.setMemberId(rs.getString(2));
				borrow.setStatus(rs.getString(3));
				borrow.setBorrowTimestamp(rs.getTimestamp(4).toString());
				
				borrows.add(borrow);
			}
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return borrows;
	}
}
