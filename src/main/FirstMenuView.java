package main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FirstMenuView extends JFrame{
	
	public FirstMenuView() {
		setTitle("Swee Library");
		  setSize(600, 400);
		  setLocationRelativeTo(null);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  
		  JLabel lblTitle;
		  JButton btnLogIn, btnCreateMember;
		  
		  lblTitle = new JLabel("Swee Library", JLabel.CENTER);
		  lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 80));
		  lblTitle.setPreferredSize(new Dimension(200, 150));
		  
		  btnLogIn = new JButton("Log In");
		  btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		  btnCreateMember = new JButton("Create Membership");
		  btnCreateMember.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		  
		  JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 15, 15));
		  buttonPanel.add(btnLogIn);
		  buttonPanel.add(btnCreateMember);
		  buttonPanel.setBorder(new EmptyBorder(50, 150, 50, 150));

		  JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
		  mainPanel.add(lblTitle, BorderLayout.NORTH);
		  mainPanel.add(buttonPanel, BorderLayout.CENTER);
		  
		  add(mainPanel);
		  
	}
	
}
