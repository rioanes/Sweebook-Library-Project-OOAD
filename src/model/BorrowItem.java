package model;

import util.*;
import java.util.*;
import controller.*;
import model.*;

public class BorrowItem {
	private String id;
	private String bookId;
	private String returnTimestamp;
	
	//constructor
	public BorrowItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorrowItem(String id, String bookId, String returnTimestamp) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.returnTimestamp = returnTimestamp;
	}
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getReturnTimestamp() {
		return returnTimestamp;
	}
	public void setReturnTimestamp(String returnTimestamp) {
		this.returnTimestamp = returnTimestamp;
	}
	
	
	public BorrowItem insert() {
		
	}
	
	public BorrowItem update() {
		
	}
	
	public boolean isBookAlreadyReturn(String id, String bookId) {
		
	}
	
	public List<BorrowItem> getBookItem(String id){
		
	}
}
