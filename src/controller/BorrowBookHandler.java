package controller;

import javax.swing.*;
import java.util.*;
import view.*;
import model.*;

public class BorrowBookHandler {
	
	private CartStorage carts = new CartStorage();
	
	public JInternalFrame showBorrowBookForm() {
		return new BorrowBookForm();
	}
	
	public List<Book> getCart() {
		List<Book> books = new ArrayList<Book>();
		books.addAll(carts.getCart());
		return books;
	}
	
	public List<Book> getAvailableBook(){
		return new BookHandler().getBookByQuantityMoreThanZero();
	}
	
	public boolean addToCart(Book book) {
		carts.addCart(book);
		return true;
	}
	
	public boolean removeCart(Book book) {
		carts.removeCart(book);
		return true;
	}
	
	public boolean borrowBook() {
		//validasi buku yg boleh di borrow maks 10 termasuk yg udah dipinjem
		Borrow borrowModel = new Borrow();
		int countBook = borrowModel.getCountBookStillBorrowing(User.getId());
		
		countBook += getCart().size();
		
		if(countBook > 10) {
			return false;
		}
		//validasi gaboleh buku yg lagi dipinjem
		List<Book> books = new ArrayList<Book>(getCart());
		
		for (Book book : books) {
			boolean cek = new Borrow().isBookStillBorrowing(User.getId(), book.getId());
			if(cek == false) {
				//print error message
				return false;
			}
		}
		//masukin ke borrow + borrowItem
		
		return true;
		
	}
}
