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

import main.FirstMenuView;

public class ManagerMainView extends JFrame implements ActionListener {
	
	ImageIcon image = new ImageIcon("aaa.png");
	
	JLabel photo;
	
	JButton viewMember, viewEmployee, viewBowHist, logOut;
	
	ViewMembershipForm viewMemForm;
	ManageEmployeeForm manEmpForm;
	BorrowHistoryForm bowHistForm;
	
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
		viewMember.setBounds(20, 60, 130, 41);
		getContentPane().add(viewMember);
		viewMember.addActionListener(this);
		
		//View Employee
		
		viewEmployee = new JButton("View Employee");
		viewEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewEmployee.setBounds(20, 140, 130, 41);
		getContentPane().add(viewEmployee);
		viewEmployee.addActionListener(this);
		
		//View Borrow History
		
		viewBowHist = new JButton("Borrow History");
		viewBowHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewBowHist.setBounds(20, 220, 130, 41);
		getContentPane().add(viewBowHist);
		viewBowHist.addActionListener(this);
		
		//Log Out
		 
		logOut = new JButton("Log Out");
		logOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logOut.setBounds(20, 300, 130, 41);
		getContentPane().add(logOut);
		logOut.addActionListener(this);
		
		//Photo
		
		photo = new JLabel("New label");
		photo.setBounds(245, 65, 284, 240);
		getContentPane().add(photo);
		photo.setIcon(image);
	}
	
	public void showViewMembershipForm() {
		if(viewMemForm == null || viewMemForm.isVisible() == false) {
	    	 if(manEmpForm != null) manEmpForm.dispose();
	    	 if(bowHistForm != null) bowHistForm.dispose();
	    	 
	    	 viewMemForm = new ViewMembershipForm();
	    	 add(viewMemForm).setSize(340,335);
	    	 remove(photo);
	     }else {
	    	 viewMemForm.dispose();
	    	 getContentPane().add(photo);
	     }
		
		
	}
	
	public void showManageEmployeeForm() {
		if(manEmpForm == null || manEmpForm.isVisible() == false) {
	    	 if(viewMemForm != null) viewMemForm.dispose();
	    	 if(bowHistForm != null) bowHistForm.dispose();
	    	 
	    	 manEmpForm = new ManageEmployeeForm();
	    	 add(manEmpForm).setSize(340, 335);
	    	 remove(photo);
	     }else {
	    	 manEmpForm.dispose();
	    	 getContentPane().add(photo);
	     }
		
	}
	
	public void showBorrowHistoryForm() {
		if(bowHistForm == null || bowHistForm.isVisible() == false) {
	    	 if(viewMemForm != null) viewMemForm.dispose();
	    	 if(manEmpForm != null) manEmpForm.dispose();
	    	 
	    	 bowHistForm = new BorrowHistoryForm();
	    	 add(bowHistForm).setSize(340, 335);
	    	 remove(photo);
	     }else {
	    	 bowHistForm.dispose();
	    	 getContentPane().add(photo);
	     }
		
	}
	
	public void logout() {
		 this.dispose();
		 FirstMenuView fmv = new FirstMenuView();
		 fmv.setVisible(true);
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
		}else if(e.getSource() == logOut) {
			logout();
		}
		
	}
}
