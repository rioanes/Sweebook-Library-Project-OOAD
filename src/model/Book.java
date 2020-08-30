package model;

import java.util.*;
import java.sql.*;
import util.*;

public class Book {
	private String id;
	private String name;
	private String genreId;
	private String isbn;
	private int quantity;
	
	final String insertString = "INSERT INTO book (id,name, genreId, isbn, quantity) VALUES (?, ?, ?, ?, ?);";
    final String updateString = "UPDATE book SET name=?, genreId=?, isbn=?, quantity=? WHERE id=? ;";
    final String deleteString = "DELETE FROM book WHERE id=? ;";
    final String selectString = "SELECT * FROM book ORDER BY id DESC;";
    final String findIdString = "SELECT * FROM book WHERE id=? ;";
    final String findIsbnString = "SELECT * FROM book WHERE isbn=? ;";
    final String selectAvailableString = "SELECT * FROM book WHERE quantity>0 ;";
	
    //constructor
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String id, String name, String genreId, String isbn, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.genreId = genreId;
		this.isbn = isbn;
		this.quantity = quantity;
	}
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenreId() {
		return genreId;
	}
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//function//
	
	public List<Book> all(){
		Connection connection = Connect.connect();
		List<Book> books = new ArrayList<Book>();
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(selectString);
			while(rs.next()) {
				Book book1 = new Book();
				book1.setId(rs.getString("id"));
				book1.setName(rs.getString("name"));
				book1.setGenreId(rs.getString("genreId"));
				book1.setIsbn(rs.getString("isbn"));
				book1.setQuantity(rs.getInt("quantity"));
				
				books.add(book1);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return books;
	}
	
	public Book find(String id) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		Book book1 = new Book();
		try {
			statement = connection.prepareStatement(findIdString);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(); //gtw butuh kasi findString ato ga
			
			book1.setId(rs.getString("id"));
			book1.setName(rs.getString("name"));
			book1.setGenreId(rs.getString("genreId"));
			book1.setIsbn(rs.getString("isbn"));
			book1.setQuantity(rs.getInt("quantity"));
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return book1;
	}
	
	public Book insert() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertString);
			statement.setString(1, this.id);
			statement.setString(2, this.name);
			statement.setString(3, this.genreId);
			statement.setString(4, this.isbn);
			statement.setInt(5, this.quantity);
			
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
	
	public Book update() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(updateString);
			statement.setString(1, this.name);
			statement.setString(2, this.genreId);
			statement.setString(3, this.isbn);
			statement.setInt(4, this.quantity);
			statement.setString(5, this.id);
			
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
	
	public boolean delete() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(deleteString);
			statement.setString(1, this.id);
			
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
		
		return true;
	}
	
	public Book getByIsbn(String isbn) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		Book book1 = new Book();
		try {
			statement = connection.prepareStatement(findIsbnString);
			statement.setString(1, isbn);
			ResultSet rs = statement.executeQuery(); //gtw butuh kasi findString ato ga
			
			//cek null ato ngga
			book1.setId(rs.getString("id"));
			book1.setName(rs.getString("name"));
			book1.setGenreId(rs.getString("genreId"));
			book1.setIsbn(rs.getString("isbn"));
			book1.setQuantity(rs.getInt("quantity"));
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return book1;
	}
	
	public List<Book> getBookByQuantityMoreThanZero(){
		Connection connection = Connect.connect();
		List<Book> books = new ArrayList<Book>();
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(selectAvailableString);
			while(rs.next()) {
				Book book1 = new Book();
				book1.setId(rs.getString("id"));
				book1.setName(rs.getString("name"));
				book1.setGenreId(rs.getString("genreId"));
				book1.setIsbn(rs.getString("isbn"));
				book1.setQuantity(rs.getInt("quantity"));
				
				books.add(book1);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return books;
	}
}
