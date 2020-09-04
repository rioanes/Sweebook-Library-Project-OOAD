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

public class Employee {
	private String id;
	private int salary;
	private String status;
	
	final String insertString = "INSERT INTO employees (user_id, salary, status) VALUES (?, ?, ?);";
    final String updateString = "UPDATE employees SET salary=?, status=? WHERE user_id=? ;";
    final String selectString = "SELECT * FROM employees ORDER BY user_id DESC;";
    final String findIdString = "SELECT * FROM employees WHERE user_id=? ;";
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String id, int salary, String status) {
		super();
		this.id = id;
		this.salary = salary;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Employee> all(){
		Connection connection = Connect.connect();
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(selectString);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getString(1));
				emp.setSalary(rs.getInt(2));
				emp.setStatus(rs.getString(3));
				
				employees.add(emp);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return employees;
	}
	
	public Employee find(String id) {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		Employee emp = new Employee();
		try {
			statement = connection.prepareStatement(findIdString);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(); //gtw butuh kasi findString ato ga
			
			while(rs.next()) {
				emp.setId(rs.getString(1));
				emp.setSalary(rs.getInt(2));
				emp.setStatus(rs.getString(3));				
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
		
		return emp;
	}
	
	public Employee insert(){
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertString);
			statement.setString(1, this.id);
			statement.setInt(2, this.salary);
			statement.setString(3, this.status);
			
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
	
	public Employee update() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(updateString);
			statement.setInt(1, this.salary);
			statement.setString(2, this.status);
			statement.setString(3, this.id);
			
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
}
