package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import com.sun.tools.javac.util.List;

import model.Member;
import controller.MemberHandler;

public class ViewMembershipForm extends JInternalFrame {
	
	List<Member> memberList = new ArrayList<Member>();
	
	TableModel dtm;
	JTable tbl;
	JScrollPane sPane;
	
	JLabel title, memID, memAdd, memSince;
	
	JButton close;
	
	JPanel titlePnl, upperPnl, tblPnl, btnPnl;
	
	public ViewMembershipForm() {
		setSize(340, 335);
		setLocation(225, 10);
		setVisible(true);
		setClosable(true);
		
		title = new JLabel("Member List");
		titlePnl = new JPanel();
		titlePnl.add(title);
		
		dtm = new DefaultTableModel(memberList.toArray(), 2);
		tbl = new JTable(dtm);
		sPane = new JScrollPane(tbl);
		
		//getMember();
		
		add(titlePnl, BorderLayout.NORTH);
		add(sPane, BorderLayout.CENTER);
	}
	
	public void getMember() {
		//Ambil Member
		memberList = new MemberHandler().getAll(); 
	}
}