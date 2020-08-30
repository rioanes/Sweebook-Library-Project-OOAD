package model;

import util.*;
import java.util.*;
import controller.*;
import model.*;

public class Employee {
	private String id;
	private int salary;
	private String status;
	
	
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
		
	}
	
	public Employee find(String id) {
		
	}
	
	public Employee insert(){
		
	}
	
	public Employee update() {
		
	}
}
