package controller;

import javax.swing.*;
import java.util.*;
import view.*;
import model.*;

public class BookHandler {
	
	public JInternalFrame showViewBookForm() {
		return new ViewBookForm();
	}
	
	public JInternalFrame showManageBookForm() {
		return new ManageBookForm();
	}
	
	public List<Book> getAll(){
		return new Book().all();
	}
	
	public Book getById(String id) {
		return new Book().find(id);
	}
	
	public Book getByIsbn(String isbn) {
		return new Book().getByIsbn(isbn);
	}
	
	public List<Book> getBookByQuantityMoreThanZero(){
		return new Book().getBookByQuantityMoreThanZero();
	}
	
	public Book insert(HashMap<String,String> inputs) {
		String id = UUID.randomUUID().toString();
		String genreId = new GenreHandler().getByType(inputs.get("genre")).getId();
		
		Book book = new Book();
		book.setId(id);
		book.setGenreId(genreId);
		book.setName(inputs.get("name"));
		book.setIsbn(inputs.get("isbn"));
		book.setQuantity(Integer.parseInt(inputs.get("quantity")));
		
		return book.insert();
	}
	
	public Book update(HashMap<String,String> inputs) {
		//blom
		Book book1 = new Book().getByIsbn(inputs.get("isbn"));
		book1.setQuantity(Integer.parseInt(inputs.get("quantity")));
		String genreId = new GenreHandler().getByType(inputs.get("genre")).getId();
		book1.setId(genreId);
		
		return book1.update();
	}
	
	public Book restockBook(String isbn) {
		Book book1 = new Book();
		book1 = book1.getByIsbn(isbn);
		
		if(book1 == null) {
			//create book
			//panggil view buat create book
			//insert book
		}else {
			//update quantity
		}
		
		return book1;
	}
	
	public boolean delete(String id) {
		Book book1 = new Book();
		
		book1 = book1.find(id);
		if(book1 == null) return false;
		else {
			return book1.delete();
		}
	}
}
