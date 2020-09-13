package view;

import java.awt.Font;

import javax.swing.*;

import main.FirstMenuView;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class PurchasingMainView extends JFrame implements ActionListener{
	ImageIcon image = new ImageIcon("aaa.png");
	JLabel photo,title;
	JButton viewBook,manage , deleteBook, btnManageGenre, logOut; 
	
	ViewBookForm view ;
	ManageBookForm manageBook ;
	ManageGenreForm manageGenre ;
	
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
		viewBook.setBounds(20, 87, 130, 41);
		viewBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(viewBook);
		viewBook.addActionListener(this);
		
		//Manage book
		manage = new JButton("Manage Book");
		manage.setBounds(20, 149, 130, 41);
		manage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(manage);
		manage.addActionListener(this);
		
		//manage genre
		btnManageGenre = new JButton("Manage Genre");
		btnManageGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnManageGenre.setBounds(20, 211, 130, 41);
		getContentPane().add(btnManageGenre);
		btnManageGenre.addActionListener(this);
		
		logOut = new JButton("Log Out");
		logOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logOut.setBounds(20, 275, 130, 41);
		getContentPane().add(logOut);
		logOut.addActionListener(this);
		
		//Photo
		
		photo = new JLabel("New label");
		photo.setBounds(245, 65, 284, 240);
		getContentPane().add(photo);
		photo.setIcon(image);
	}
	
	public void ViewBookForm() {
		if(view == null || view.isVisible() == false)  {
			if( manageBook != null) manageBook.dispose();
			if(manageGenre != null) manageGenre.dispose();
			
			view = new ViewBookForm();
			add(view).setSize(340, 335);
			remove(photo);
		}else{
			view.dispose();
			getContentPane().add(photo);
		}
	   
	}
	 
	public void ManageBookForm() {
		if(manageBook == null || manageBook.isVisible() == false){
			if( view != null) view.dispose();
			if( manageGenre != null) manageGenre.dispose();
			
			manageBook = new ManageBookForm();
			add(manageBook).setSize(340, 335);
			remove(photo);
		}else {
			manageBook.dispose();
			getContentPane().add(photo);
		}
	}
	 
	public void ManageGenreForm() {
		if(manageGenre == null || manageGenre.isVisible() == false){
			if( view != null) view.dispose();
			if( manageBook != null) manageBook.dispose();
			
			manageGenre = new ManageGenreForm();
			add(manageGenre).setSize(340, 335);
			remove(photo);
		}else  {
			manageGenre.dispose();
			getContentPane().add(photo);
		}
	}
	
	public void logout() {
		 this.dispose();
		 FirstMenuView fmv = new FirstMenuView();
		 fmv.setVisible(true);
		
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
	    else if(e.getSource() == logOut) {
			logout();
		}
		
	}
}
