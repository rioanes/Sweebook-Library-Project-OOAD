package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;

import model.Book;

public class ManageGenreForm extends JInternalFrame implements ActionListener {
 
	 List<Book> genreList = new ArrayList<Book>();
	 PurchasingMainView purchasingMain;
	 
	 JTable tbl;
	 JScrollPane sPane;
	 JLabel title;
	 JButton close;
	 JButton create;
	 JPanel titlePnl, btnPnl;
	 JLabel lblType,tit, tit1;
	 JTextField txtType;
	 JPanel jp;
	 
	 public ManageGenreForm() {
		 setVisible(true);
		 setSize(340, 335);
		 setLocation(225, 10);
	  
		 title = new JLabel("Genre List");
		 titlePnl = new JPanel();
		 titlePnl.add(title);
	  
		 TableModel tableModel = new DefaultTableModel(genreList.toArray(),2);
		 JTable table = new JTable(tableModel);
	  
		 getGenre();
	  
		 close = new JButton("Back");
		 create = new JButton("create");
		 btnPnl = new JPanel(new FlowLayout());
		 btnPnl.add(create);
		 btnPnl.add(close);
		 create.addActionListener(new ActionListener() {
			
			@Override
		 public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new JOptionPane().showInputDialog(null, "Insert Type");
				
			}
		 });
		 
		 tit = new JLabel("Create Type");
		 tit1 = new JLabel("");
		 lblType = new JLabel("Type Name");
		 txtType = new JTextField();
		 jp = new JPanel(new GridLayout(2,2));
		 
		 JPanel pnl = new JPanel(new BorderLayout());
		 pnl.add(new JScrollPane(table), BorderLayout.CENTER);
		 pnl.add(jp, BorderLayout.SOUTH);
		 
		 getContentPane().add(titlePnl, BorderLayout.NORTH);
		 getContentPane().add(pnl, BorderLayout.CENTER);
		 getContentPane().add(btnPnl, BorderLayout.SOUTH);
		 
	 }
	 
	 public void getGenre() {
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
}