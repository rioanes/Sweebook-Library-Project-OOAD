package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;

public class CreateMembershipForm extends JFrame{
	private JTextField txtName;
	private JTextField txtUserName;
	private JTextArea txtAddress;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	public CreateMembershipForm() {
		setTitle("Register Form");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//judul
		JLabel title = new JLabel("Create MemberShip");
		title.setFont(new Font("Gabriola", Font.PLAIN, 37));
		
		//name
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName = new JTextField();
		
		//username
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUserName = new JTextField();
		
		//gender
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
			//grouping
		ButtonGroup group = new ButtonGroup();
		JRadioButton rbMale = new JRadioButton("Male");
		JRadioButton rbFemale = new JRadioButton("Female");
		group.add(rbFemale);
		group.add(rbMale);
		
		//address
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 203, 60, 14);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
			//scroll
		txtAddress = new JTextArea();
		JScrollPane spAddress = new JScrollPane(txtAddress);
		
		//password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword = new JPasswordField();
		
		//confirm password
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtConfirmPassword = new JPasswordField();
		
		//create
		JButton create = new JButton("create");
		create.setFont(new Font("Tahoma", Font.PLAIN, 15));
		create.setSize(20, 20);
		
		//txtAddress.setPreferredSize(new Dimension(400,150));
		
		JPanel pnlGender = new JPanel(new GridLayout(1,2));
		pnlGender.add(rbMale);
		pnlGender.add(rbFemale);
		
		JPanel pnlForm = new JPanel(new GridLayout(8,2,5,5));
		pnlForm.add(lblName);
		pnlForm.add(txtName);
		pnlForm.add(lblUserName);
		pnlForm.add(txtUserName);
		pnlForm.add(lblPassword);
		pnlForm.add(txtPassword);
		pnlForm.add(lblConfirmPassword);
		pnlForm.add(txtConfirmPassword);
		pnlForm.add(lblGender);
		pnlForm.add(pnlGender);
		pnlForm.add(lblAddress);
		pnlForm.add(spAddress);
		
		JPanel pnlWithAgree = new JPanel(new BorderLayout());
		pnlWithAgree.add(pnlForm,BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(title, BorderLayout.NORTH);
		panel.add(pnlWithAgree, BorderLayout.CENTER);
		panel.add(pnlForm, BorderLayout.CENTER);
		panel.add(create, BorderLayout.SOUTH);
		panel.setBorder(new EmptyBorder(20,20,20,20));
		add(panel);
	}
}
