package view;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import main.FirstMenuView;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MemberMainView extends JFrame implements ActionListener{
	 BorrowBookForm borrowBookForm = new BorrowBookForm();
	 BorrowHistoryForm borrowHisForm = new BorrowHistoryForm();
	 ViewBookForm viewBookForm = new ViewBookForm();
	 ViewBorrowForm viewBorForm = new ViewBorrowForm();
	 ViewGenreForm viewGenre = new ViewGenreForm();
	 CreateGenreForm createGenre = new CreateGenreForm();
	 RestockBookForm restockBook = new RestockBookForm();

  
	 JDesktopPane viewer = new JDesktopPane();
	 
	 JLabel title;
	 JButton borrowBook, viewBook, viewBorrow, borrowHistory;
	 private JButton btnLogOut;
	 JLabel photo;
	  
 public MemberMainView() {
	  getContentPane().setLayout(null);
	  setTitle("Membership Main Menu");
	  setSize(600,400);
	  setLocationRelativeTo(null);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  //title
	  title = new JLabel("Membership Menu");
	  title.setBounds(20, 31, 227, 54);
	  title.setFont(new Font("Gabriola", Font.PLAIN, 34));
	  getContentPane().add(title);
	  
	  //borrow book
	  borrowBook = new JButton("Borrow Book");
	  borrowBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
	  borrowBook.setBounds(20, 84, 130, 41);
	  getContentPane().add(borrowBook);
	  borrowBook.addActionListener(this);
	
	  //view book
	  viewBook = new JButton("View Book");
	  viewBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
	  viewBook.setBounds(20, 136, 130, 41);
	  getContentPane().add(viewBook);
	  viewBook.addActionListener(this);
	  
	  //view borrow
	  viewBorrow = new JButton("View Borrow");
	  viewBorrow.setFont(new Font("Tahoma", Font.PLAIN, 12));
	  viewBorrow.setBounds(20, 188, 130, 41);
	  getContentPane().add(viewBorrow);
	  viewBorrow.addActionListener(this);
	  
	  //borrow history
	  borrowHistory = new JButton("Borrow History");
	  borrowHistory.setFont(new Font("Tahoma", Font.PLAIN, 12));
	  borrowHistory.setBounds(20, 240, 130, 41);
	  getContentPane().add(borrowHistory);
	  borrowHistory.addActionListener(this);
	  
	  //log out
	  btnLogOut = new JButton("Log Out");
	  btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	  btnLogOut.setBounds(20, 292, 130, 41);
	  getContentPane().add(btnLogOut);
	  
	  //photo
	  photo = new JLabel("New label");
	  photo.setBounds(245, 65, 284, 240);
	  getContentPane().add(photo);
	  photo.setIcon(new ImageIcon("C:\\rio\\cawu 3.2\\2) Object Oriented Analysis & Design\\7) Project\\Sweebook-Library-Project-OOAD\\aaa.png"));
	 }
	// private void removeInternalFrames() {
	//
	//    BorrowBookForm.getInstance().destroy();
	//    ViewBookForm.getInstance().destroy();
	//    ViewBorrowForm.getInstance().destroy();
	//    ViewBorrowHistoryForm.getInstance().destroy();
	// }
	 
	 public JInternalFrame showBorrowBookForm() {
	     remove(photo);
	     borrowBookForm = new BorrowBookForm();
	     add(borrowBookForm).setSize(340, 335);
	     return borrowBookForm;
	 }
	 
	 public JInternalFrame showViewBookForm() {
	     remove(photo);
	     viewGenre = new ViewGenreForm();
	     add(viewGenre).setSize(340, 335);
	     return viewGenre;
	 }
	 
	 public JInternalFrame showViewBorrowForm() {
		 remove(photo);
		 viewBorForm = new ViewBorrowForm();
		 add(viewBorForm).setSize(340, 335);
		 return viewBorForm;
	 }
	 
	 public JInternalFrame showBorrowHistoryForm() {
		 remove(photo);
		 borrowHisForm = new BorrowHistoryForm();
		 add(borrowHisForm).setSize(340, 335);
		 return borrowHisForm;
	 }
	 
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource() == borrowBook) {
			 showBorrowBookForm();
		 }
	     else if(e.getSource() == viewBook) {
	    	 showViewBookForm();
	     }
	     else if(e.getSource() == viewBorrow) {
	    	 showViewBorrowForm();
	     }
	     else if(e.getSource() == borrowHistory) {
	    	 showBorrowHistoryForm();
	     }
		 	getContentPane().add(photo);
	 }
}