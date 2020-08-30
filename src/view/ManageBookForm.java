package view;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Book;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ManageBookForm extends JInternalFrame implements ActionListener{

	 ManageGenreForm manGen= new ManageGenreForm();
	 PurchasingMainView purchasingMain;
	
	 List<Book> BookList = new ArrayList<Book>();
	 List<Book> genreList = new ArrayList<Book>();
	 
	 JScrollPane sPane, sPaneCart;
	 JLabel title,titleCart;
	 JButton close,restock, delete, viewGen;
	 JPanel titlePnl,titlePnlCart;
	 JSpinner spQuantity;
	 JTable table;
	 
	 public ManageBookForm() {
		 setVisible(true);
		 setSize(340, 335);
		 setLocation(225, 10);
	  
		 title = new JLabel("Book List");
		 titlePnl = new JPanel();
		 titlePnl.add(title);
		 
		 //book list
		 TableModel tableModel = new DefaultTableModel(BookList.toArray(),2);
		 table = new JTable(tableModel);
	  
		 getBook();
		 
		 //restock book data
//		 bookTitle = new JLabel("Title");
//		 bookISBN = new JLabel("ISBN");
//		 bookGenre = new JLabel("Genre");
//		 bookQuantity = new JLabel("quantity");
//		 
//		 txtTitle = new JTextField();
//		 txtISBN = new JTextField();
//		 txtGenre = new JTextField();
//		 SpinnerNumberModel snm = new SpinnerNumberModel(17,12,100,1); //agar angkanya bisa diatur 
//		 spQuantity = new JSpinner();
		 
		 //button
		 close = new JButton("Back");
		 restock = new JButton("Restock Book");
		 delete = new JButton("Delete Book");
		 viewGen = new JButton("View Genre");
		 close.addActionListener(this);
		 restock.addActionListener(this);
		 delete.addActionListener(this);
		 viewGen.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remove(getContentPane());
				manGen = new ManageGenreForm();
				add(manGen).setSize(340,355);
			}
		 });
		 restock.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				 new JOptionPane().showInputDialog(null, "Input ISBN");
			}
		 });
		 delete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				 if(index == -1) {
					 new JOptionPane().showMessageDialog(null, "Please Choose 1 Employee!");
					return;
				 }
				 else {
					 int ans = JOptionPane.showConfirmDialog(null, "Do you want to delete book?");
					 switch(ans){
			         case JOptionPane.YES_OPTION: 
			             JOptionPane.showInputDialog(this, "Deleted Successfully");
			             BookList.remove(index);
			             break;
			         case JOptionPane.NO_OPTION:
			             break;
					 }
				 }
			}
		 });
		 
		 JPanel pnlButton = new JPanel(new FlowLayout());
		 pnlButton.add(close);
		 pnlButton.add(restock);
		 pnlButton.add(delete);
		 pnlButton.add(viewGen);
	  
		 getContentPane().add(titlePnl, BorderLayout.NORTH);
		 getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		 getContentPane().add(pnlButton, BorderLayout.SOUTH);
	 }
	 
	 private void getBook() {
//		 BookList = new BookHandler().getAll();
//			for (int i = 0; i < BookList.length; i++) {
//				String id = BookList.get(i).getID;
//				String Name = BookList.get(i).getName;
//				int quantity = BookList.get(i).getQuantity;
//				String genreId = BookList.get(i).getGenreId;
//	 
//				Object[] data = {id,Name,quantity,genreId};
//	 
//				tableModel.add(data);
//			}
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource() == close) {
//			dispose();
//		}
//		else if(e.getSource() == delete) {
//			delConfirm();
//		}
//		else if (e.getSource() == restock) {
//			resConfirm();
//		}
//		else if (e.getSource() == viewGen) {
//			showViewGenreForm();
//		}
		
	 }
	
//	 public void delConfirm() {
//		 int index = table.getSelectedRow();
//		 if(index == -1) {
//			 new JOptionPane().showMessageDialog(null, "Please Choose 1 Employee!");
//			return;
//		 }
//		 else {
//			 int ans = JOptionPane.showConfirmDialog(this, "Do you want to delete book?");
//			 switch(ans){
//	         case JOptionPane.YES_OPTION: 
//	             JOptionPane.showMessageDialog(this, "Deleted Successfully");
//	             BookList.remove(index);
//	             break;
//	         case JOptionPane.NO_OPTION:
//	             break;
//			 }
//		 }
//	 }
//	 
//	 public void resConfirm() {
//		 new JOptionPane().showInputDialog(null, "Input ISBN");
////		 if(IsValid==true) {
////			 JOptionPane.showMessageDialog(this, "Restock Successfully");
////		 	 BookList.add();
////		 }
////		 else {
////			 JOptionPane.showMessageDialog(this, "Your ISBN is not valid, please input again !");
////		 }
//	 }
//	 
//	 public JInternalFrame showViewGenreForm() {
//		 remove(getContentPane());
//		 manGen = new ManageGenreForm();
//		 add(manGen).setSize(340,355);
//		 return manGen;
//	 }
}