package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import controller.*;
import model.Book;

public class BorrowBookForm extends JInternalFrame implements ActionListener {
	 private BorrowBookHandler bbh;
	
	 //get list
//	 Vector<Object> bookList = new Vector<Object>();
//	 Vector<Object> cartList = new Vector<Object>();
	 
	 List<Book> bookList = new ArrayList<Book>();
	 List<Book> cartList = new ArrayList<Book>();
	 
	 //create ui
	 DefaultTableModel dtm;
	 DefaultTableModel dtmCart;
	 JTable tbl;
	 JTable tblCart;
	 JScrollPane sPane;
	 JScrollPane sPaneCart;
	 JLabel title;
	 JLabel titleCart;
	 JButton close;
	 JButton borrow;
	 JPanel titlePnl;
	 JPanel titlePnlCart;
	 
	 public BorrowBookForm() {
		 setVisible(true);
		 setSize(340, 335);
		 setLocation(225, 10);
		 
		 //initialize handler
		 bbh = new BorrowBookHandler();
	  
		 title = new JLabel("Book List");
		 TableModel tableModelBook = new DefaultTableModel(bookList.toArray(),2);
		 JTable tableBook = new JTable(tableModelBook);
		 
		 //book list
		 getBook();
		 
		 //cart List
		 titleCart = new JLabel("Cart List");
		 TableModel tableModelCart = new DefaultTableModel(cartList.toArray(),2);
		 JTable tableCart = new JTable(tableModelCart);
		 
		 getCartList();
		 
		 //button
		 close = new JButton("Close");
		 borrow = new JButton("Borrow");
		 
		 JPanel pnlList = new JPanel(new GridLayout(4,1,5,5));
		 pnlList.add(title);
		 pnlList.add(new JScrollPane(tableBook));
		 pnlList.add(titleCart);
		 pnlList.add(new JScrollPane(tableCart));
		 
		 JPanel pnlButton = new JPanel(new FlowLayout());
		 pnlButton.add(close);
		 pnlButton.add(borrow);
	  
//		 getContentPane().add(titlePnl, BorderLayout.NORTH);
		 getContentPane().add(pnlList, BorderLayout.CENTER);
		 getContentPane().add(pnlButton, BorderLayout.SOUTH);
		
		 
	 }
	 private void getBook() {
//		bookList = new BorrowBookHandler().getAvailableBook();
	 }
	 
	 private void getCartList() {
//		cartList = new BorrowBookHandler().getCart();
	}
	 
	 @Override
	 public void actionPerformed(ActionEvent e) {
	 // TODO Auto-generated method stub
	 if(e.getSource() == close) {
		 dispose();
	 }
 }
}