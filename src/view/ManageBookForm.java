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

import controller.BookHandler;
import model.Book;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ManageBookForm extends JInternalFrame implements ActionListener{

	 ManageGenreForm manGen= new ManageGenreForm();
	 PurchasingMainView purchasingMain;
	 BookHandler bookHan = new BookHandler();
	
	 List<Book> BookList = new ArrayList<Book>();

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
		 setClosable(true);
	  
		 title = new JLabel("Book List");
		 titlePnl = new JPanel();
		 titlePnl.add(title);
		 
		 
		 //book list
		 String[] ListBookName = {"ID", "Name", "Genre ID", "ISBN", "Qty"};
		 TableModel tableModel = new DefaultTableModel(ListBookName,BookList.size());
		 table = new JTable(tableModel);
		 
		 getBook();
		 
		 //button
		 close = new JButton("Back");
		 restock = new JButton("Restock Book");
		 delete = new JButton("Delete Book");
		 close.addActionListener(this);
		 restock.addActionListener(this);
		 delete.addActionListener(this);
		 
		 restock.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {

				JTextField name = new JTextField();
				JTextField genre = new JTextField();
				JTextField ISBN = new JTextField();
				JSpinner quantity = new JSpinner();
				Object[] message = {
				    "Input Book Name:", name,
				    "Input Genre :", genre,
				    "Input ISBN:", ISBN,
				    "Input Quantity:", quantity,
				};
				int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION)
				{
				    String valueName = name.getText();
				    String valueGenre = genre.getText();
				    String valueISBN = ISBN.getText();
				    int valueQuantity = (Integer) quantity.getValue();
				    if(valueName.length()<1 || valueGenre.length()<1 || valueISBN.length()<1 || valueQuantity == 0) {
				    	new JOptionPane().showMessageDialog(null, "Please Completed the Data !");
				    	return;
				    }
				    else {
//						bookHan.restockBook(valueName, valueGenreId, valueISBN, valueQuantity);		    	
				    }
				}
			}
		 });
		 delete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				 if(index == -1) {
					 new JOptionPane().showMessageDialog(null, "Choose Book to Deleted!");
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
				 getBook();
			}
		 });
		 
		 JPanel pnlButton = new JPanel(new FlowLayout());
		 pnlButton.add(close);
		 pnlButton.add(restock);
		 pnlButton.add(delete);
	  
		 getContentPane().add(titlePnl, BorderLayout.NORTH);
		 getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		 getContentPane().add(pnlButton, BorderLayout.SOUTH);
	 }
	 
	 private void getBook() {
//			bookList = new book.getAll();
			
			for (int i = 0 ; i < BookList.size() ; i++) {
//				String id = bookList.get(i).getId();
//				String name = bookList.get(i).getName();
//				String genreId = bookList.get(i).getGenreId();
//				String isbn = bookList.get(i).getIsbn();
//				int qty = bookList.get(i).getQuantity();
	// 
//				tableBook.setValueAt(id, i, 0);
//				tableBook.setValueAt(name, i, 1);
//				tableBook.setValueAt(genreId, i, 2);
//				tableBook.setValueAt(isbn, i, 3);
//				tableBook.setValueAt(qty, i, 4);
			}
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	 }

}