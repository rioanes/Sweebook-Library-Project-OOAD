package view;

import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class PurchasingMainView extends JFrame implements ActionListener{
	JLabel photo,title;
	JButton viewBook,manage , deleteBook, btnManageGenre; 
	
	ViewBookForm view ;
	ManageBookForm manageBook ;
	ManageGenreForm manageGenre ;
	
	public PurchasingMainView() {
		view = new ViewBookForm();
		manageBook = new ManageBookForm();
		manageGenre = new ManageGenreForm();
		
		view.setVisible(false);
		manageBook.setVisible(false);
		manageGenre.setVisible(false);
		
		add(view);
		add(manageBook);
		add(manageGenre);
		
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

		add_photo();
	}
	
	public void add_photo() {
		//photo
		photo = new JLabel("New label");
		photo.setBounds(245, 65, 284, 240);
		getContentPane().add(photo);
		photo.setIcon(new ImageIcon("C:\\rio\\cawu 3.2\\2) Object Oriented Analysis & Design\\7) Project\\Sweebook-Library-Project-OOAD\\aaa.png"));
				
	}
	
	
	public JInternalFrame ViewBookForm() {
		if(view.isVisible() == true) {
			view.dispose();
		}else {
			manageBook.dispose();
			manageGenre.dispose();
			
			view = new ViewBookForm();
			add(view);
		}
	   
	    return view;
	}
	 
	public JInternalFrame ManageBookForm() {
		if(manageBook.isVisible() == true) {
			manageBook.dispose();
		}else {
			view.dispose();
			manageGenre.dispose();
			
			manageBook = new ManageBookForm();
			add(manageBook);
			
		}
	    return manageBook;
	}
	 
	public JInternalFrame ManageGenreForm() {
		if(manageGenre.isVisible() == true) {
			manageGenre.dispose();
		}else {
			view.dispose();
			manageBook.dispose();
			
			manageGenre = new ManageGenreForm();
			add(manageGenre);
			
		}
		 
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
