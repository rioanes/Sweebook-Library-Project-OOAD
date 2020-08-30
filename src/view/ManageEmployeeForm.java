package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import controller.*;
import model.*;

public class ManageEmployeeForm extends JInternalFrame implements ActionListener {
	
	List<Employee> employeeList = new ArrayList<Employee>();
	
	DefaultTableModel dtm;
	JTable tbl;
	JScrollPane sPane;
	
	JLabel title;
	
	JButton addEmp, fireEmp, accReq;
	
	JPanel titlePnl, btnPnl;
	
	Employee choosedEmployee;
	
	JLabel lblSalary, lblStatus;
	
	JTextField txtSalary, txtStatus;
	
	JInternalFrame addEmploy;
	
	public ManageEmployeeForm() {
		setVisible(true);
		setSize(340, 335);
		setLocation(225, 10);
		setClosable(true);
		
		title = new JLabel("Employee List");
		titlePnl = new JPanel();
		titlePnl.add(title);
		
		dtm = new DefaultTableModel(employeeList.toArray(), 2);
		tbl = new JTable(dtm);
		sPane = new JScrollPane(tbl);
		
		getEmployee();
		
		addEmp = new JButton("Add");
		addEmp.addActionListener(this);
		
		fireEmp = new JButton("Fire");
		fireEmp.addActionListener(this);
		
		accReq = new JButton("Accept");
		accReq.addActionListener(this);
		
		btnPnl = new JPanel(new GridLayout(1, 3));
		btnPnl.add(addEmp);
		btnPnl.add(fireEmp);
		btnPnl.add(accReq);
		
		add(titlePnl, BorderLayout.NORTH);
		add(sPane, BorderLayout.CENTER);
		add(btnPnl, BorderLayout.SOUTH);
	}
	
	public void getEmployee() {
		employeeList = new EmployeeHandler().getAll();
	}
	
	public void addEmployee() {
		addEmploy = new JInternalFrame();
        add(addEmploy);
        addEmploy.setVisible(true);
        
		lblSalary = new JLabel("Salary");
		lblStatus = new JLabel("Status");
		
		txtSalary = new JTextField();
		txtStatus = new JTextField();
		
		int salary = Integer.parseInt(txtSalary.getText());
		String status = txtStatus.getText();
		
		JPanel pane = new JPanel(new GridLayout(2, 2, 5, 5));
		pane.add(lblSalary);
		pane.add(txtSalary);
		pane.add(lblStatus);
		pane.add(txtStatus);
		
		employeeList.add(salary, status);
	}
	
	public void fireEmployee() {
		int index = tbl.getSelectedRow();
		if(index == -1) {
			new JOptionPane().showMessageDialog(null, "Please Choose 1 Employee!");
			return;
		}
		//ini harusnya remove tapi gatau caranya :(
		getEmployee();
	}
	
	public void acceptReqs() {
		int index = tbl.getSelectedRow();
		if(index == -1) {
			new JOptionPane().showMessageDialog(null, "Please Choose 1 Employee!");
			return;
		}
		choosedEmployee.setStatus("Accepted");
		getEmployee();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addEmp) {
			addEmployee();
		}
		else if(e.getSource() == fireEmp) {
			if(User.getRoleId() == new RoleHandler().getByName("manager").getId()) {
				fireEmployee();
			}
			else {
				new JOptionPane().showMessageDialog(null, "You Cannot Do This Action");
			}
		}
		else if(e.getSource() == accReq) {
			if(User.getRoleId() == new RoleHandler().getByName("manager").getId()) {
				acceptReqs();
			}
			else {
				new JOptionPane().showMessageDialog(null, "You Cannot Do This Action");
			}
		}
	}
}
