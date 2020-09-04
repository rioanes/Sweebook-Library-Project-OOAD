package view;
 
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
import controller.BorrowTransactionHandler;
import controller.RoleHandler;
import model.Borrow;
import model.BorrowItem;
import model.User;
 
//import com.sun.tools.javac.util.List;
 
public class BorrowHistoryForm extends JInternalFrame implements ActionListener {
 
	List<Borrow> borrowList = new ArrayList<Borrow>();
	List<BorrowItem> borrowItem = new ArrayList<BorrowItem>();
	BorrowTransactionHandler borHandler = new BorrowTransactionHandler();
 
	DefaultTableModel bowDtm, detDtm;
	JTable bowTbl, detTbl;
	JScrollPane bowPane, detPane;
	JLabel title;
	JDialog getDate;
	JButton viewDetail, monthAndYear, returnBut;
	JPanel titlePnl, tblPnl, btnPnl;
	LocalDate now;
	JSpinner month , year;
 
	public BorrowHistoryForm() {
		setVisible(true);
		setSize(340, 335);
		setLocation(225, 10);
		setClosable(true);
 
		title = new JLabel("Borrow History");
		titlePnl = new JPanel();
		titlePnl.add(title);
 
		getBorrowHistory();
 
		makeDetail();
 
		tblPnl = new JPanel(new GridLayout(2, 1));
		tblPnl.add(bowPane);
		tblPnl.add(detPane);
 
		viewDetail = new JButton("Borrow Detail");
		viewDetail.addActionListener(this);
		
		monthAndYear = new JButton("Filter");
		monthAndYear.addActionListener(this);
		
		returnBut = new JButton("Return Book");
		returnBut.addActionListener(this);
		
		btnPnl = new JPanel(new FlowLayout());
		btnPnl.add(viewDetail);
		btnPnl.add(monthAndYear);
		btnPnl.add(returnBut);
 
		add(titlePnl, BorderLayout.NORTH);
		add(tblPnl, BorderLayout.CENTER);
		add(btnPnl, BorderLayout.SOUTH);
	}
 
	public void getBorrowHistory() {
		//Get Date
		now = LocalDate.now();
		int month = now.getMonthValue();
		int year = now.getYear();
 
		String combine = String.valueOf(month) + "-" + String.valueOf(year);
 
		SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
		Date date = new Date();
		try {
			date = sdf.parse(combine);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		//IsMember?
 
		boolean isMember;
 
//		if(User.getRoleId().compareTo(new RoleHandler().getByName("member").getId()) == 0) isMember = true;
//		else isMember = false;
 
//		borrowList = new BorrowTransactionHandler().getAcceptStatus(date, isMember);
 
		String[] names = {"ID", "Member ID", "Status","Borrow Time"};
 
		bowDtm = new DefaultTableModel(names, borrowList.size());
		bowTbl = new JTable(bowDtm);
		bowPane = new JScrollPane(bowTbl);
 
		showBorrowHistory();
	}
 
	public void showBorrowHistory() {
		for (int i = 0; i < borrowList.size(); i++) {
//			String id = borrowList.get(i).getId();
//			String name = borrowList.get(i).getMemberId();
//			String status = borrowList.get(i).getStatus();
//			String bowTime = borrowList.get(i).getBorrowTimestamp();
// 
//			bowDtm.setValueAt(id, i, 0);
//			bowDtm.setValueAt(name, i, 1);
//			bowDtm.setValueAt(status, i, 2);
//			bowDtm.setValueAt(bowTime, i, 3);
		}
	}
 
	public void makeDetail() {
		String[] names = {"ID", "Book ID", "Return Time"};
 
		detDtm = new DefaultTableModel(names, 0);
		detTbl = new JTable(detDtm);
		detPane = new JScrollPane(detTbl);
	}
 
	public void viewDetail() {
		int index = bowTbl.getSelectedRow();
		if(index == -1) {
			new JOptionPane().showMessageDialog(null, "Please Choose 1 Transaction!");
			return;
		}
 
//		String curId = borrowList.get(index).getId();
 
//		borrowItem = new BorrowTransactionHandler().getBookItem(curId);
 
		for (int i = 0; i < borrowItem.size(); i++) {
//			String id = borrowItem.get(i).getId();
//			String bookId = borrowItem.get(i).getBookId();
//			String retTime = borrowItem.get(i).getReturnTimestamp();

//			String bookName = new BookHandler().getById(bookId).getName();
			
//			detDtm.setValueAt(id, i, 0);
//			detDtm.setValueAt(bookName, i, 1);
//			detDtm.setValueAt(retTime, i, 2);
		}
	}
	
	private void returnBook() {
		// TODO Auto-generated method stub
		int index = detTbl.getSelectedRow(); 
		 if(index == -1) {
			 new JOptionPane().showMessageDialog(null, "Choose Book to returned!");
			return;
		 }
		 else {
			 int ans = JOptionPane.showConfirmDialog(null, "Do you want to return book?");
			 switch(ans){
	         case JOptionPane.YES_OPTION: 
	             JOptionPane.showInputDialog(this, "Return Book Successfully");
	             //remove
	             borrowList.remove(index);
	             //update
//	             borHandler.update();
	             break;
	         case JOptionPane.NO_OPTION:
	             break;
			 }
		 }
		 getBorrowHistory();
		 showBorrowHistory();
	}
	
	private void filter() {
		JLabel tit = new JLabel();
		JSpinner Smonth = new JSpinner();
	    JSpinner Syear = new JSpinner();
	    Calendar cal = Calendar.getInstance();
	    Date date = cal.getTime();
	    SimpleDateFormat sdf_Month = new SimpleDateFormat("MM");
	    SimpleDateFormat sdf_Year = new SimpleDateFormat("yyyy");
	    SimpleDateFormat sdf_final_Date = new SimpleDateFormat("MMMM yyyy");
        JLabel label = new JLabel();
	       
	    Smonth.setModel(new SpinnerDateModel(date, null, null, cal.MONTH));
	    Smonth.setEditor(new JSpinner.DateEditor(Smonth, "MMMM"));
        Syear.setModel(new SpinnerDateModel(date, null, null, cal.YEAR));
	    Syear.setEditor(new JSpinner.DateEditor(Syear, "yyyy"));
		Object[] message = {
				"Filter History at : ", tit,
				"Month", Smonth,
				"Year", Syear
			};
	    int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
		    String valueMonth = (String) Smonth.getValue();
		    int valueYear = (Integer) Smonth.getValue();
//		    borHandler.getAcceptStatus(valueMonth, valueYear);
//		    showBorrowHistory();
		}

	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == viewDetail) {
			viewDetail();
		}
		if(e.getSource() == monthAndYear) {
			filter();
		}
		if(e.getSource() == returnBut) {
			returnBook();
		}
	}
 
}