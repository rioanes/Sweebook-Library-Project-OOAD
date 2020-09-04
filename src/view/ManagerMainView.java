package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class ManagerMainView extends JFrame implements ActionListener {
	
	ImageIcon image = new ImageIcon("aaa.png");
	
	JLabel photo;
	
	JButton viewMember, viewEmployee, viewBowHist;
	
	ViewMembershipForm viewMemForm;
	ManageEmployeeForm manEmpForm;
	ViewBorrowHistoryForm bowHistForm;
	
	public ManagerMainView() {
		
		getContentPane().setLayout(null);
		setTitle("Manager Main Menu");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Title
		
		JLabel title = new JLabel("Manager Menu");
		title.setBounds(20, 22, 434, 54);
		title.setFont(new Font("Gabriola", Font.PLAIN, 34));
		getContentPane().add(title);
		
		//View Membership
		
		viewMember = new JButton("View Membership");
		viewMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewMember.setBounds(20, 80, 130, 41);
		getContentPane().add(viewMember);
		viewMember.addActionListener(this);
		
		//View Employee
		
		viewEmployee = new JButton("View Employee");
		viewEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewEmployee.setBounds(20, 180, 130, 41);
		getContentPane().add(viewEmployee);
		viewEmployee.addActionListener(this);
		
		//View Borrow History
		
		viewBowHist = new JButton("Borrow History");
		viewBowHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewBowHist.setBounds(20, 280, 130, 41);
		getContentPane().add(viewBowHist);
		viewBowHist.addActionListener(this);
		
		//Photo
		
		photo = new JLabel("New label");
		photo.setBounds(245, 65, 284, 240);
		getContentPane().add(photo);
		photo.setIcon(image);
	}
	
	public JInternalFrame showViewMembershipForm() {
		remove(photo);
		viewMemForm = new ViewMembershipForm();
		add(viewMemForm).setSize(340,335);
		return viewMemForm;
	}
	
	public JInternalFrame showManageEmployeeForm() {
		remove(photo);
		manEmpForm = new ManageEmployeeForm();
		add(manEmpForm).setSize(340, 335);
		return manEmpForm;
	}
	
	public JInternalFrame showBorrowHistoryForm() {
		remove(photo);
		bowHistForm = new ViewBorrowHistoryForm();
		add(bowHistForm).setSize(340, 335);
		return bowHistForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == viewMember) {
			showViewMembershipForm();
		}
		else if(e.getSource() == viewEmployee) {
			showManageEmployeeForm();
		}
		else if(e.getSource() == viewBowHist) {
			showBorrowHistoryForm();
		}
		getContentPane().add(photo);
	}
}
