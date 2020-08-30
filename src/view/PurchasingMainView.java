package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class PurchasingMainView extends JFrame implements ActionListener{
	JLabel photo,title;
	JButton viewBook,viewGenreBook, deleteBook;
	
	ViewBookForm view = new ViewBookForm();
	ManageBookForm manageBook = new ManageBookForm();
	
	public PurchasingMainView() {
		getContentPane().setLayout(null);
		setTitle("Purchasing Main Menu");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//title
		title = new JLabel("Purchasing Menu");
		title.setBounds(20, 22, 434, 54);
		title.setFont(new Font("Gabriola", Font.PLAIN, 34));
		getContentPane().add(title);
		
		//view book
		viewBook = new JButton("View Book");
		viewBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewBook.setBounds(20, 120, 130, 41);
		getContentPane().add(viewBook);
		
		//Manage book
		viewGenreBook = new JButton("Manage Book");
		viewGenreBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewGenreBook.setBounds(20, 186, 130, 41);
		getContentPane().add(viewGenreBook);

		//photo
		photo = new JLabel("New label");
		photo.setBounds(245, 65, 284, 240);
		getContentPane().add(photo);
		photo.setIcon(new ImageIcon("C:\\rio\\cawu 3.2\\2) Object Oriented Analysis & Design\\7) Project\\Sweebook-Library-Project-OOAD\\aaa.png"));
	    
	}
	 public JInternalFrame ViewBookForm() {
	     remove(photo);
	     view = new ViewBookForm();
	     add(view).setSize(340, 335);
	     return view;
	 }
	 
	 public JInternalFrame ManageBookForm() {
	     remove(photo);
	     manageBook = new ManageBookForm();
	     add(manageBook).setSize(340, 335);
	     return manageBook;
	 }
	 
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource() == view) {
			 ViewBookForm();
		 }
	     else if(e.getSource() == manageBook) {
	    	 ManageBookForm();
	     }
		 	getContentPane().add(photo);
	 }

}
