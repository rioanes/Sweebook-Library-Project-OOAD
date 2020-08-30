package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;
import controller.*;


public class LogInView extends JFrame implements ActionListener {
	
	JLabel title, lblUsername, lblPassword;
	
	JTextField txtUsername;
	
	JPasswordField txtPassword;
	
	JButton logInButton;
	
	String username, password;
	
	User user = new User();
	
	public LogInView() {
		
		getContentPane().setLayout(null);
		setTitle("Swee Library");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		title = new JLabel("Please enter your username and password to continue", JLabel.CENTER);
		title.setBounds(48, 20, 500, 40);
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		getContentPane().add(title);
		
		lblUsername = new JLabel("Username :");
		lblUsername.setBounds(110, 120, 100, 40);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		getContentPane().add(lblUsername);
		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(110, 200, 100, 40);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(250, 120, 240, 40);
		getContentPane().add(txtUsername);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(250, 200, 240, 40);
		getContentPane().add(txtPassword);
		
		username = txtUsername.getText();
		password = String.valueOf(txtPassword.getPassword());
		
		logInButton = new JButton("Log In");
		logInButton.setBounds(235, 300, 100, 40);
		getContentPane().add(logInButton);
		logInButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == logInButton) {
			username = txtUsername.getText();
			password = String.valueOf(txtPassword.getPassword());
			UserHandler userH = new UserHandler();
			user = userH.getByUsername(username); //Ini cek Username sama Password nya sesuai apa ngga
			System.out.println("User username:" + user.getUsername());
			if(user.getUsername() == null) {
				//print username salah
				System.out.println("username salah");
				return;
			}else if(user.getPassword().equals(password) == false) {
				//print password salah
				System.out.println("Login pass:" + password);
				System.out.println("User pass:" + user.getPassword());
				System.out.println("password salah");
				return;
			}
			//Harusnya disini ada kondisi kalo ga sesuai
			//Ini kondisi kalo sesuai
			this.dispose();
			
			RoleHandler roleH = new RoleHandler();
			
			if(User.getRoleId().equals(roleH.getByName("Manager").getId()) == true) {
				ManagerMainView managerView = new ManagerMainView();
				managerView.setVisible(true);
			}
//			else if(user.getRoleId() == roleH.getByName( "Human Capital").getId()) {
//				HumanCapitalMainView humanView = new HumanCapitalMainView();
//				humanView.setVisible(true);
//			}
//			else if(user.getRoleId() == roleH.getByName( "Administrator").getId()) {
//				AdministratorMainView adminView = new AdministratorMainView();
//				adminView.setVisible(true);
//			}
			else if(User.getRoleId().equals(roleH.getByName( "Membership").getId()) == true) {
				MemberMainView memberView = new MemberMainView();
				memberView.setVisible(true);
			}
//			else if(user.getRoleId() == roleH.getByName( "Purchasing").getId()) {
//				PurchasingMainView purchaseView = new PurchasingMainView();
//				purchaseView.setVisible(true);
//			}
		}
	}
}
