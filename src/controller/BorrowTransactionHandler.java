package controller;

import view.*;
import java.util.*;
import javax.swing.*;
import model.*;

public class BorrowTransactionHandler {
	
	public JInternalFrame showBorrowForm() {
		return new BorrowBookForm();
	}
	
	public JInternalFrame showBorrowHistoryForm() {
		return new BorrowHistoryForm();
	}
	
	public List<Borrow> getPendingStatus(boolean isOnlyCurrentMember) {
		return new Borrow().getPendingStatus(isOnlyCurrentMember);
	}
	
	public List<Borrow> getAcceptStatus(Date date, boolean isOnlyCurrentMember){
		return new Borrow().getAcceptStatus(date, isOnlyCurrentMember);
	}
	
	public List<BorrowItem> getBookItem(String id){
		return new BorrowItem().getBookItem(id);
	}
	
	public boolean acceptBorrowRequest(String id) {
		Borrow borrow = new Borrow().find(id);
		borrow.setStatus("accept");
		borrow.update();
		
		return true;
	}
	
	public BorrowItem returnBook(HashMap<String, String> inputs) { 
		
	}
}
