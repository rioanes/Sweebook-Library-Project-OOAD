package controller;

import javax.swing.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import view.*;
import model.*;

public class BorrowBookHandler {
	
	private CartStorage carts = new CartStorage();
	
	public JInternalFrame showBorrowBookForm() {
		return new BorrowBookForm();
	}
	
	public List<Book> getCart() {
		System.out.println("inside getCart");
		List<Book> books = new ArrayList<Book>();
		books.addAll(carts.getCart());
		
		System.out.println("after getcart");
		return books;
	}
	
	public List<Book> getAvailableBook(){
		return new BookHandler().getBookByQuantityMoreThanZero();
	}
	
	public boolean addToCart(Book book) {
		System.out.println("add to cart");
		
		if(carts.isAlreadyExist(book)) {
			System.out.println("book already in cart");
			JOptionPane.showMessageDialog(null, "Book already in cart!");
			return false;
		}
		
		if(book.getQuantity() <= 0) {
			JOptionPane.showMessageDialog(null, "No books left");
			return false;
		}
		
		//update quantity
		HashMap<String, String> inputs = new HashMap<String, String>();
		inputs.put("isbn", book.getIsbn());
		inputs.put("genreId", book.getGenreId());
		inputs.put("quantity", "-1");
		new BookHandler().update(inputs);
		
		book.setQuantity(1);
		carts.addCart(book);
		
		System.out.println("done add to cart");
		return true;
	}
	
	public boolean removeCart(Book book) {
		HashMap<String, String> inputs = new HashMap<String, String>();
		inputs.put("isbn", book.getIsbn());
		inputs.put("genreId", book.getGenreId());
		inputs.put("quantity", "1");
		new BookHandler().update(inputs);
		
		carts.removeCart(book);
		return true;
	}
	
	public boolean borrowBook() {
		//validasi buku yg boleh di borrow maks 10 termasuk yg udah dipinjem
		Borrow borrowModel = new Borrow();
		int countBook = borrowModel.getCountBookStillBorrowing(User.getId());
		
		if(getCart().size() == 0) {
			System.out.println("no book in cart");
			return false;
		}
		
		countBook += getCart().size();
		
		if(countBook > 10) {
			//books can't be more than 10
			JOptionPane.showMessageDialog(null, "Can't borrow more than 10 books!!");
			return false;
		}
		
		//validasi gaboleh buku yg lagi dipinjem
		List<Book> books = new ArrayList<Book>(getCart());
		
		for (Book book : books) {
			boolean cek = new Borrow().isBookStillBorrowing(User.getId(), book.getId());
			if(cek == true) {
				//print error message
				JOptionPane.showMessageDialog(null, "Can't borrow the same book!!");
				return false;
			}
		}
		
		//masukin ke borrow 
		Borrow borrow = new Borrow();
		String borrowId = UUID.randomUUID().toString();
		borrow.setId(borrowId);
		borrow.setMemberId(User.getId());
		borrow.setStatus("pending");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String borrowTimestamp = dtf.format(now).toString();
		borrow.setBorrowTimestamp(borrowTimestamp);
		borrow.insert();
		
		//remove all cart and insert to borrowItem
		for (Book book : books) {
			BorrowItem bItem = new BorrowItem();
			bItem.setBookId(book.getId());
			bItem.setId(borrowId);
			bItem.setReturnTimestamp("");
			
			bItem.insert();
			carts.removeCart(book);
		}
		
		return true;
		
	}
}
