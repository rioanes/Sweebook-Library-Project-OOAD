package model;

import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import controller.*;
import model.*;

public class Genre {
	private String id;
	private String type;
	
	final String selectString = "SELECT * FROM genre ORDER BY id DESC;";
	final String insertString = "INSERT INTO genre (id,type) VALUES (?, ?);";
	final String findIdString = "SELECT * FROM genre WHERE type=? ;";
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Genre(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Genre> all(){
		Connection connection = Connect.connect();
		List<Genre> genres = new ArrayList<Genre>();
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(selectString);
			while(rs.next()) {
				Genre genre = new Genre();
				genre.setId(rs.getString("id"));
				genre.setType(rs.getString("type"));
				
				genres.add(genre);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return genres;
	}
	
	public Genre insert() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertString);
			statement.setString(1, this.id);
			statement.setString(2, this.type);
			
			
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
	
	public Genre getByType(String type) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		Genre genre = new Genre();
		try {
			statement = connection.prepareStatement(findIdString);
			statement.setString(1, type);
			ResultSet rs = statement.executeQuery(); //gtw butuh kasi findString ato ga
			
			genre.setId(rs.getString("id"));
			genre.setType(rs.getString("type"));
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return genre;
	}
}
