package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import main.FirstMenuView;

public class AdministratorMainView extends JFrame implements ActionListener {
	
	ImageIcon image = new ImageIcon("aaa.png");
	
	JLabel photo;
	
	JButton viewBook, viewPendBowBook, viewMember, viewBowHist, logOut;
	
	ViewBookForm viewBookForm;
	ViewBorrowForm viewBowForm;
	ViewMembershipForm viewMemForm;
	BorrowHistoryForm bowHistForm;
	
	public AdministratorMainView() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		setTitle("Administrator Main Menu");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Title
		
		JLabel title = new JLabel("Administrator Menu");
		title.setBounds(20, 22, 434, 54);
		title.setFont(new Font("Gabriola", Font.PLAIN, 34));
		getContentPane().add(title);
		
		//View Book
		
		viewBook = new JButton("View Book");
		viewBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewBook.setBounds(20, 60, 130, 41);
		getContentPane().add(viewBook);
		viewBook.addActionListener(this);
		
		//View Pending Borrow Book
		
		viewPendBowBook = new JButton("View Pending Borrow Book");
		viewPendBowBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewPendBowBook.setBounds(20, 120, 130, 41);
		getContentPane().add(viewPendBowBook);
		viewPendBowBook.addActionListener(this);
		
		//View Membership
		
		viewMember = new JButton("View Membership");
		viewMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewMember.setBounds(20, 180, 130, 41);
		getContentPane().add(viewMember);
		viewMember.addActionListener(this);
		
		//View Borrow History
		
		viewBowHist = new JButton("Borrow History");
		viewBowHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewBowHist.setBounds(20, 240, 130, 41);
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
	
	public void showViewBookForm() {
		if(viewBookForm == null || viewBookForm.isVisible() == false) {
	    	 if(viewBowForm != null) viewBowForm.dispose();
	    	 if(viewMemForm != null) viewMemForm.dispose();
	    	 if(bowHistForm != null) bowHistForm.dispose();
	    	 
	    	 viewBookForm = new ViewBookForm();
	    	 add(viewBookForm).setSize(340, 335);
	    	 remove(photo);
	    	 
	     }else {
	    	 viewBookForm.dispose();
	    	 getContentPane().add(photo);
	     }
		
	}
	
	public void showViewBorrowForm() {
		if(viewBowForm == null || viewBowForm.isVisible() == false) {
			if(viewBookForm != null) viewBookForm.dispose();
	    	if(viewMemForm != null) viewMemForm.dispose();
	    	if(bowHistForm != null) bowHistForm.dispose();
	    	 
	    	viewBowForm = new ViewBorrowForm();
			add(viewBowForm).setSize(340, 335);
			remove(photo);
	    }else {
	    	viewBowForm.dispose();
	    	getContentPane().add(photo);
	    }
		
	}
	
	public void showViewMembershipForm() {
		if(viewMemForm == null || viewMemForm.isVisible() == false) {
			if(viewBookForm != null) viewBookForm.dispose();
	    	if(viewBowForm != null) viewBowForm.dispose();
	    	if(bowHistForm != null) bowHistForm.dispose();
	    	 
	    	viewMemForm = new ViewMembershipForm();
			add(viewMemForm).setSize(340, 335);
			remove(photo);
	    }else {
	    	viewMemForm.dispose();
	    	getContentPane().add(photo);
	    }
		
	}
	
	public void showBorrowHistoryForm() {
		if(bowHistForm == null || bowHistForm.isVisible() == false) {
			if(viewBookForm != null) viewBookForm.dispose();
	    	if(viewBowForm != null) viewBowForm.dispose();
	    	if(viewMemForm != null) viewMemForm.dispose();
	    	 
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
		if(e.getSource() == viewBook) {
			showViewBookForm();
		}
		else if(e.getSource() == viewPendBowBook) {
			showViewBorrowForm();
		}
		else if(e.getSource() == viewMember) {
			showViewMembershipForm();
		}
		else if(e.getSource() == viewBowHist) {
			showBorrowHistoryForm();
		}
		else if(e.getSource() == logOut) {
			logout();
		}
		
	}
}