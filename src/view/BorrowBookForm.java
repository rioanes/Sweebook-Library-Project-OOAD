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
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import controller.*;
import model.*;

public class BorrowBookForm extends JInternalFrame implements ActionListener {
	 private BorrowBookHandler bbh;
	
	 //get list
	 
	 List<Book> bookList = new ArrayList<Book>();
	 List<Book> cartList = new ArrayList<Book>();
	 
	 BookHandler book = new BookHandler();
	 
	 //create ui
	 DefaultTableModel dtm;
	 DefaultTableModel dtmCart;
	 JTable tbl;
	 JTable tblCart;
	 JScrollPane sPane;
	 JScrollPane sPaneCart;
	 JLabel title;
	 JLabel titleCart;
	 JButton close,borrow,add,remove;
	 JPanel titlePnl;
	 JPanel titlePnlCart;
	 JTable tableBook,tableCart;
	 
	 public BorrowBookForm() {
		 setVisible(true);
		 setSize(340, 335);
		 setLocation(225, 10);
		 setClosable(true);
 
		 title = new JLabel("Book List");
		 		  
		 //book list
		 
		 String[] ListBookName = {"ID", "Name", "Genre ID", "ISBN", "Qty"};
		 TableModel tableModelBook = new DefaultTableModel(ListBookName,bookList.size());
		 tableBook = new JTable(tableModelBook);
		 
		 getBookList();
		 //cart List
		 titleCart = new JLabel("Cart List");
		 
		 String[] CartListName = {"ID", "Name", "Genre ID", "ISBN", "Qty"};
		 TableModel tableModelCart = new DefaultTableModel(CartListName,cartList.size());
		 tableCart = new JTable(tableModelCart);
		 
		 getCartList();
		 
		 //button
//		 close = new JButton("Close");
		 borrow = new JButton("Borrow");
		 add = new JButton("add to cart");
		 remove = new JButton("remove from cart");
		 
		 add.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableBook.getSelectedRow();
				if(index == -1) {
					new JOptionPane().showMessageDialog(null, "Choose Book Do You Want Add to Cart!");
					return;
				}
				else {
//					book.addToCart(bookList.get(index));	
				}
			}
		 });
		 
		 remove.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableCart.getSelectedRow();
				if(index == -1) {
					new JOptionPane().showMessageDialog(null, "Choose Book Do You Want remove!");
					return;
				}
				else {
					int ans = new JOptionPane().showConfirmDialog(null, "Do You Want to Remove This Book?");
					 switch(ans){
				        case JOptionPane.YES_OPTION: 
				        	tableCart.clearSelection();		
				        	new JOptionPane().showMessageDialog(null, "Remove Successed !");
				            break;
				        case JOptionPane.NO_OPTION:
				            break;
				    }
				}
			}
		 });
		 
		 JPanel pnlListBook = new JPanel(new GridLayout(2,1));
		 pnlListBook.setBorder(BorderFactory.createTitledBorder(
			      BorderFactory.createEtchedBorder(), "Book List", TitledBorder.LEFT,
			      TitledBorder.TOP));
		 pnlListBook.add(new JScrollPane(tableBook));
		 
		 JPanel pnlListCart = new JPanel(new GridLayout(2,1));
		 pnlListCart.add(new JScrollPane(tableCart));
		 pnlListCart.setBorder(BorderFactory.createTitledBorder(
			      BorderFactory.createEtchedBorder(), "Cart List", TitledBorder.LEFT,
			      TitledBorder.TOP));
		 
		 JPanel pnlList = new JPanel(new GridLayout(2,1));
		 pnlList.add(pnlListBook);
		 pnlList.add(pnlListCart);
		 
		 
		 JPanel pnlButton = new JPanel(new FlowLayout());
//		 pnlButton.add(close);
		 pnlButton.add(borrow);
		 pnlButton.add(add);
		 pnlButton.add(remove);
	  
		 getContentPane().add(pnlList, BorderLayout.CENTER);
		 getContentPane().add(pnlButton, BorderLayout.SOUTH);
		
		 
	 }
	 private void getBookList(){
//		bookList = new book.getAll();
		
		for (int i = 0 ; i < bookList.size() ; i++) {
//			String id = bookList.get(i).getId();
//			String name = bookList.get(i).getName();
//			String genreId = bookList.get(i).getGenreId();
//			String isbn = bookList.get(i).getIsbn();
//			int qty = bookList.get(i).getQuantity();
// 
//			tableBook.setValueAt(id, i, 0);
//			tableBook.setValueAt(name, i, 1);
//			tableBook.setValueAt(genreId, i, 2);
//			tableBook.setValueAt(isbn, i, 3);
//			tableBook.setValueAt(qty, i, 4);
		}
	 }
	 
	 private void getCartList() {
//		cartList = new book.getCart();
			
		for (int i = 0 ; i < cartList.size() ; i++) {
//			String id = bookList.get(i).getId();
//			String name = bookList.get(i).getName();
//			String genreId = bookList.get(i).getGenreId();
//			String isbn = bookList.get(i).getIsbn();
//			int qty = bookList.get(i).getQuantity();
// 
//			tableCart.setValueAt(id, i, 0);
//			tableCart.setValueAt(name, i, 1);
//			tableCart.setValueAt(genreId, i, 2);
//			tableCart.setValueAt(isbn, i, 3);
//			tableCart.setValueAt(qty, i, 4);
			}
	}
	 
	 @Override
	 public void actionPerformed(ActionEvent e) {
	 // TODO Auto-generated method stub
	 if(e.getSource() == close ) {
		 this.dispose();
	 }
 }
}