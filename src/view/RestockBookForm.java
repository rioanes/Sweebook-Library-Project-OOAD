package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class RestockBookForm extends JInternalFrame implements ActionListener {
 
	 Vector<Object> bookList = new Vector<Object>();
	 Vector<Object> cartList = new Vector<Object>();
	 
	 DefaultTableModel dtm,dtmCart;
	 JTable tbl,tblCart;
	 JScrollPane sPane, sPaneCart;
	 JLabel title,titleCart;
	 JButton close,borrow;
	 JPanel titlePnl,titlePnlCart;
	 JLabel bookTitle,bookISBN, bookGenre, bookQuantity;
	 JTextField txtTitle, txtISBN, txtGenre, txtQuantity;
	 JSpinner spQuantity;
	 
	 public RestockBookForm() {
		 setVisible(true);
		 setSize(340, 335);
		 setLocation(225, 10);
	  
		 title = new JLabel("Book List");
		 titlePnl = new JPanel();
		 titlePnl.add(title);
		 
		 //book list
		 bookList.add("Title");
		 bookList.add("Genre");
		 bookList.add("ISBN");
		 dtm = new DefaultTableModel(bookList, 0);
		 tbl = new JTable(dtm);
		 sPane = new JScrollPane(tbl);
	  
		 getBook();
		 
		 //restock book data
		 bookTitle = new JLabel("Title");
		 bookISBN = new JLabel("ISBN");
		 bookGenre = new JLabel("Genre");
		 bookQuantity = new JLabel("quantity");
		 
		 txtTitle = new JTextField();
		 txtISBN = new JTextField();
		 txtGenre = new JTextField();
		 SpinnerNumberModel snm = new SpinnerNumberModel(17,12,100,1); //agar angkanya bisa diatur 
		 spQuantity = new JSpinner();
		 
		 //button
		 close = new JButton("Back");
		 borrow = new JButton("Add");

		 JPanel pnlLabel = new JPanel(new GridLayout(4,2,5,5));
		 pnlLabel.add(bookTitle);
		 pnlLabel.add(txtTitle);
		 pnlLabel.add(bookISBN);
		 pnlLabel.add(txtISBN);
		 pnlLabel.add(bookGenre);
		 pnlLabel.add(txtGenre);
		 pnlLabel.add(bookQuantity);
		 pnlLabel.add(spQuantity);
		 
		 JPanel pnlList = new JPanel(new GridLayout(2,1,5,5));
		 pnlList.add(sPane);
		 pnlList.add(pnlLabel);
		 
		 JPanel pnlButton = new JPanel(new FlowLayout());
		 pnlButton.add(close);
		 pnlButton.add(borrow);
	  
		 getContentPane().add(titlePnl, BorderLayout.NORTH);
		 getContentPane().add(pnlList, BorderLayout.CENTER);
		 getContentPane().add(pnlButton, BorderLayout.SOUTH);
		
		 
	 }
	 private void getBook() {
		// TODO Auto-generated method stub
		
	 }
	 
	 @Override
	 public void actionPerformed(ActionEvent e) {
	 // TODO Auto-generated method stub
	 if(e.getSource() == close) {
		 dispose();
	 }
 }
}