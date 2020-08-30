package model;
import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import controller.*;
import model.*;


public class User {
	private static String id;
	private static String roleId;
	private String name;
	private String username;
	private String password;
	private String gender;
	
	final String insertString = "INSERT INTO users (id,role_id, name, username, password, gender) VALUES (?, ?, ?, ?, ?, ?);";
	final String findIdString = "SELECT * FROM users WHERE username=? ;";
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String roleId, String name, String username, String password, String gender) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender;
	}
	
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		User.id = id;
	}
	public static String getRoleId() {
		return roleId;
	}
	public static void setRoleId(String roleId) {
		User.roleId = roleId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public User insert() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertString);
			statement.setString(1, this.id);
			statement.setString(2, this.roleId);
			statement.setString(3, this.name);
			statement.setString(4, this.username);
			statement.setString(5, this.password);
			statement.setString(6, this.gender);
			
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
	
	
	public User getByUsername(String username) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		User user = new User();
		
		try {
			statement = connection.prepareStatement(findIdString);
			System.out.println("lalala: " + username);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery(); //gtw butuh kasi findString ato ga
			while(rs.next()) {
				User.setId(rs.getString(1));
				User.setRoleId(rs.getString(2));
				user.setName(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setGender(rs.getString(6));
				System.out.println(user.getPassword() + "== pass");
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("error");
			return null;
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return user;
	}
}
