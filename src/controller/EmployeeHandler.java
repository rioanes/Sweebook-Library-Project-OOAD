package controller;

import java.util.*;
import javax.swing.*;
import model.*;
import view.*;

public class EmployeeHandler {
	public JInternalFrame showManageEmployeeForm() {
		return new ManageEmployeeForm();
	}
	
	public List<Employee> getAll() {
		return new Employee().all();
	}
	
	public Employee findById(String id) {
		return new Employee().find(id);
	}
	
	public Employee insert(HashMap<String, String> inputs) {
		String id = UUID.randomUUID().toString();
		Employee employee = new Employee(id,Integer.parseInt(inputs.get("salary")),inputs.get("status"));
		return employee.insert();
		
	}
	
	public Employee update(HashMap<String, String> inputs) {
		Employee employee = new Employee(inputs.get("id"),Integer.parseInt(inputs.get("salary")),inputs.get("status") );
		
		return employee.update();
	}
	
	public Employee createWithPendingStatus(HashMap<String, String> inputs ) {
		inputs.put("status", "pending");
		return insert(inputs);
	}
	
	public Employee createWithActiveStatus(HashMap<String, String> inputs ) {
		inputs.put("status", "active");
		return insert(inputs);
	}
	
	public Employee firedEmployee(String id) {
		Employee employee = new Employee().find(id);
		employee.setStatus("fired");
		
		HashMap<String, String> inputs = new HashMap<String,String>();
		inputs.put("id", employee.getId());
		inputs.put("salary", Integer.toString(employee.getSalary()) );
		inputs.put("status", employee.getStatus());
		
		return update(inputs);
	}
	
	public Employee acceptEmployee(String id) {
		Employee employee = new Employee().find(id);
		employee.setStatus("active");
		
		HashMap<String, String> inputs = new HashMap<String,String>();
		inputs.put("id", employee.getId());
		inputs.put("salary", Integer.toString(employee.getSalary()) );
		inputs.put("status", employee.getStatus());
		
		return update(inputs);
	}
}
