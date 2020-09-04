package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class HumanCapitalMainView extends JFrame implements ActionListener {
	
	ImageIcon image = new ImageIcon("aaa.png");
	
	JLabel photo;
	
	JButton viewEmployee;
	
	ManageEmployeeForm manEmpForm;
	
	public HumanCapitalMainView() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		setTitle("Manager Main Menu");
		setSize(1360, 769);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Title
		
		JLabel title = new JLabel("Human Capital Menu");
		title.setBounds(20, 22, 434, 54);
		title.setFont(new Font("Gabriola", Font.PLAIN, 34));
		getContentPane().add(title);
		
		//View Employee
		
		viewEmployee = new JButton("View Employee");
		viewEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewEmployee.setBounds(20, 180, 130, 41);
		getContentPane().add(viewEmployee);
		viewEmployee.addActionListener(this);
		
		//Photo
		
		photo = new JLabel("New label");
		photo.setBounds(245, 65, 284, 240);
		getContentPane().add(photo);
		photo.setIcon(image);
	}
	
	public JInternalFrame showManageEmployeeForm() {
		remove(photo);
		manEmpForm = new ManageEmployeeForm();
		add(manEmpForm).setSize(340, 335);
		return manEmpForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == viewEmployee) {
			showManageEmployeeForm();
		}
	}
}