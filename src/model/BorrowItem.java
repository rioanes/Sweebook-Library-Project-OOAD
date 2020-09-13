package model;

import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BorrowItem {
	private String id;
	private String bookId;
	private String returnTimestamp;
	
	final String insertString = "INSERT INTO borrow_items (borrow_id, book_id) VALUES (?, ?);";
    final String updateString = "UPDATE borrow_items SET return_timestamp=? WHERE borrow_id=? AND book_id = ?;";
    final String findBookString = "SELECT * FROM borrow_items WHERE borrow_id=? AND book_id = ?;";
    final String getBookItemString = "SELECT * FROM borrow_items WHERE borrow_id=? ;";
    
	//constructor
	public BorrowItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorrowItem(String id, String bookId, String returnTimestamp) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.returnTimestamp = returnTimestamp;
	}
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getReturnTimestamp() {
		return returnTimestamp;
	}
	public void setReturnTimestamp(String returnTimestamp) {
		this.returnTimestamp = returnTimestamp;
	}
	
	//function
	
	public BorrowItem insert() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertString);
			statement.setString(1, this.id);
			statement.setString(2, this.bookId);
			
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
	
	public BorrowItem update() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(updateString);
			statement.setString(1, this.returnTimestamp);
			statement.setString(2, this.id);
			statement.setString(3, this.bookId);
		
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
	
	public boolean isBookAlreadyReturn(String id, String bookId) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		String timestamp = null;
		System.out.println();
		
		try {
			statement = connection.prepareStatement(findBookString);
			statement.setString(1, id);
			statement.setString(2, this.bookId);
			ResultSet rs = statement.executeQuery(); 
			
			while(rs.next()) {
				timestamp = rs.getString(3);					
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
		
		if(timestamp == null) 
			return false;
		return true;
	}
	
	public List<BorrowItem> getBookItem(String id){
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		
		List<BorrowItem> items = new ArrayList<BorrowItem>();
	
		try {
			statement = connection.prepareStatement(getBookItemString);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(); 
			
			while(rs.next()) {
				BorrowItem  item = new BorrowItem();
				item.setId(rs.getString(1));
				item.setBookId(rs.getString(2));
				item.setReturnTimestamp(rs.getString(3));
				
				items.add(item);
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
		
		return items;
	}
}
