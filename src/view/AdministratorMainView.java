package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class AdministratorMainView extends JFrame implements ActionListener {
	
	ImageIcon image = new ImageIcon("aaa.png");
	
	JLabel photo;
	
	JButton viewBook, viewPendBowBook, viewMember, viewBowHist;
	
	ViewBookForm viewBookForm;
	ViewBorrowForm viewBowForm;
	ViewMembershipForm viewMemForm;
	ViewBorrowHistoryForm bowHistForm;
	
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
		viewPendBowBook.setBounds(20, 140, 130, 41);
		getContentPane().add(viewPendBowBook);
		viewPendBowBook.addActionListener(this);
		
		//View Membership
		
		viewMember = new JButton("View Membership");
		viewMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewMember.setBounds(20, 220, 130, 41);
		getContentPane().add(viewMember);
		viewMember.addActionListener(this);
		
		//View Borrow History
		
		viewBowHist = new JButton("Borrow History");
		viewBowHist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewBowHist.setBounds(20, 300, 130, 41);
		getContentPane().add(viewBowHist);
		viewBowHist.addActionListener(this);
		
		//Photo
		
		photo = new JLabel("New label");
		photo.setBounds(245, 65, 284, 240);
		getContentPane().add(photo);
		photo.setIcon(image);
	}
	
	public JInternalFrame showViewBookForm() {
		remove(photo);
		viewBookForm = new ViewBookForm();
		add(viewBookForm).setSize(340, 335);
		return viewBookForm;
	}
	
	public JInternalFrame showViewBorrowForm() {
		remove(photo);
		viewBowForm = new ViewBorrowForm();
		add(viewBowForm).setSize(340, 335);
		return viewBowForm;
	}
	
	public JInternalFrame showViewMembershipForm() {
		remove(photo);
		viewMemForm = new ViewMembershipForm();
		add(viewMemForm).setSize(340, 335);
		return viewMemForm;
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
		getContentPane().add(photo);
	}
}