package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import controller.MemberHandler;
import main.FirstMenuView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.*; 

public class CreateMembershipForm extends JFrame implements ActionListener{
	private JTextField txtName;
	private JTextField txtUserName;
	private JTextArea txtAddress;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	
	MemberHandler member = new MemberHandler();
	FirstMenuView menu;
	
	public CreateMembershipForm() {
		setTitle("Register Form");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//judul
		JLabel title = new JLabel("                            Create MemberShip");
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
		rbMale.setActionCommand("Male");
		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setActionCommand("Female");
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
		create.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button dipencet");
				String name = txtName.getText();
				String userName = txtUserName.getText();
				System.out.println("sblm gender");
				String gender = group.getSelection().getActionCommand();
				System.out.println("stelah gender");
				String address = txtAddress.getText();
				String pass = txtPassword.getText();
				String confPass = txtConfirmPassword.getText();
				
				System.out.println(gender);
				System.out.println("mo validasi");
				
				if(name.length()<1 || userName.length()<1 || address.length()<1
						|| pass.length()<1 || confPass.length()<1
						|| gender == null) {
					new JOptionPane().showMessageDialog(null, "please complete data");
					return;
				}
				else if(!(pass.equals(confPass))) {
					System.out.println(pass);
					System.out.println(confPass);
					new JOptionPane().showMessageDialog(null, "Please input the same password");
					return;
				}
				HashMap<String,String> inputs = new HashMap<String,String>();
				inputs.put("name", name);
				inputs.put("username", userName);
				inputs.put("gender", gender);
				inputs.put("address", address);
				inputs.put("password", pass);
				System.out.println("sblm");
				member.createMembership(inputs);
				
				viewMenuForm();
			}
		});
		
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
		add(panel);
	}
	
	public JFrame viewMenuForm() {
		this.dispose();
		menu = new FirstMenuView();
		menu.setVisible(true);
		return menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}