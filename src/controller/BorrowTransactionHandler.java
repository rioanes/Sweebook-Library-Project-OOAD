package controller;

import view.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	public List<Borrow> getAcceptStatus(Date date){
		boolean isOnlyCurrentMember = User.isRoleMember();
		return new Borrow().getAcceptStatus(date, isOnlyCurrentMember);
	}
	
	public List<BorrowItem> getBookItem(String id){
		return new BorrowItem().getBookItem(id);
	}
	
	public boolean acceptBorrowRequest(String id) {
		Borrow borrow = new Borrow().find(id);
		System.out.println("parameter id " + id);
		System.out.println("borrow id " +borrow.getId());
		borrow.setStatus("accept");
		try {
			borrow.update();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public long returnBook(HashMap<String, String> inputs) {
		BorrowItem item = new BorrowItem();
		item.setId(inputs.get("id"));
		item.setBookId(inputs.get("bookId"));
		
		if(item.isBookAlreadyReturn(item.getId(), item.getBookId()) == true) {
			JOptionPane.showMessageDialog(null, "Book is Already Returned!");
			return -1;
		}
		
		//update Borrow Item
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime returnDate = LocalDateTime.now();
		String returnTimestamp = dtf.format(returnDate).toString();
		
		item.setReturnTimestamp(returnTimestamp);
		System.out.println(item.getId() + " " + item.getBookId() + " " + item.getReturnTimestamp());
		item.update();
		
		//Get Book Data
		BookHandler bookH = new BookHandler();
		Book book = bookH.getById(inputs.get("bookId"));
		
		//Update Quantity
		HashMap<String,String> bookData = new HashMap<String, String>();
		bookData.put("isbn",book.getIsbn());
		bookData.put("genreId", book.getGenreId());
		bookData.put("quantity", "1");
		bookH.update(bookData);
		
		//Calculate Fine
		Borrow borrow = new Borrow().find(item.getId());
		java.sql.Timestamp borrowTs = java.sql.Timestamp.valueOf(borrow.getBorrowTimestamp());
		System.out.println(borrowTs);
		
		java.sql.Timestamp returnTs = java.sql.Timestamp.valueOf(returnDate);
		System.out.println(returnTs);
		
		long diff = returnTs.getTime() - borrowTs.getTime();
		diff = diff / 1000 / 60 / 60 / 24;
		System.out.println(diff);
		long fine = 0;
		if(diff > 14) {
			diff -= 14;
			fine = diff * 1000;
		}
		
		System.out.println(fine);
		return fine;
	}
}
