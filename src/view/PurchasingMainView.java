package view;

import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class PurchasingMainView extends JFrame implements ActionListener{
	JLabel photo,title;
	JButton viewBook,manage , deleteBook, btnManageGenre; 
	
	ViewBookForm view = new ViewBookForm();
	ManageBookForm manageBook = new ManageBookForm();
	ManageGenreForm manageGenre = new ManageGenreForm();
	
	public PurchasingMainView() {
		setTitle("Purchasing Main Menu");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//title
		title = new JLabel("Purchasing Menu");
		title.setBounds(20, 22, 434, 54);
		title.setFont(new Font("Gabriola", Font.PLAIN, 34));
		getContentPane().add(title);
		
		//view book
		viewBook = new JButton("View Book");
		viewBook.setBounds(20, 120, 130, 41);
		viewBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(viewBook);
		viewBook.addActionListener(this);
		
		//Manage book
		manage = new JButton("Manage Book");
		manage.setBounds(20, 186, 130, 41);
		manage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(manage);
		manage.addActionListener(this);
		
		//manage genre
		btnManageGenre = new JButton("Manage Genre");
		btnManageGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnManageGenre.setBounds(20, 250, 130, 41);
		getContentPane().add(btnManageGenre);
		btnManageGenre.addActionListener(this);

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
	 
	 public JInternalFrame ManageGenreForm() {
		 remove(photo);
		 manageGenre = new ManageGenreForm();
		 add(manageGenre).setSize(340,335);
		 return manageGenre;
	 }
	 
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource() == viewBook) {
			 ViewBookForm();
		 }
	     else if(e.getSource() == manage) {
	    	 ManageBookForm();
	     }
	     else if(e.getSource() == btnManageGenre) {
	    	 ManageGenreForm();
	     }
	 getContentPane().add(photo);
	 }
}
