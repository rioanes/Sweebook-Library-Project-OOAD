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


public class Role {
	private String id;
	private String name;
	
	final String selectString = "SELECT * FROM roles ORDER BY id DESC;";
    final String findIdString = "SELECT * FROM roles WHERE name=? ;";
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
	public List<Role> all(){
		Connection connection = Connect.connect();
		List<Role> roles = new ArrayList<Role>();
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(selectString);
			while(rs.next()) {
				Role role = new Role();
				role.setId(rs.getString("id"));
				role.setName(rs.getString("name"));
				roles.add(role);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return roles;
	}
	
	public Role getByName(String name) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		Role role = new Role();
		try {
			System.out.println("role.getbyname()");
			statement = connection.prepareStatement(findIdString);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery(); //gtw butuh kasi findString ato ga
			while(rs.next()) {
				role.setId(rs.getString(1));
				role.setName(rs.getString(2));		
				
				System.out.println(role.getId() + " " + role.getName());
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
		
		return role;
	}
}
