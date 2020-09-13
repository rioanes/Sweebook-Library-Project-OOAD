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
		//create id
		String id = UUID.randomUUID().toString();
		
		//check genre
		Genre genre =  new GenreHandler().getByType(inputs.get("type"));
		if(genre.getId() == null) {
			
			genre = new GenreHandler().insert(inputs);
			
		}
		String genreId = genre.getId();
		
		//create book
		Book book = new Book();
		book.setId(id);
		book.setGenreId(genreId);
		book.setName(inputs.get("name"));
		book.setIsbn(inputs.get("isbn"));
		book.setQuantity(Integer.parseInt(inputs.get("quantity")));
		
		book = book.insert();
		JOptionPane.showMessageDialog(null, "Book Inserted");
		
		return book;
	}
	
	public Book update(HashMap<String,String> inputs) {
		
		Book book1 = new Book().getByIsbn(inputs.get("isbn"));
		
		if(inputs.containsKey("genreId") == false) {
			Genre genre =  new GenreHandler().getByType(inputs.get("type"));
			if(genre == null) {
				genre = new GenreHandler().insert(inputs);
			}
			String genreId = genre.getId();				
			book1.setGenreId(genreId);
		}
		
		book1.setQuantity(book1.getQuantity() + Integer.parseInt(inputs.get("quantity")));
		
		book1 = book1.update();
		JOptionPane.showMessageDialog(null, "Book Updated");
		return book1;
	}
	
	public Book restockBook(HashMap<String,String> inputs) {
		Book book1 = new Book();
		book1 = book1.getByIsbn(inputs.get("isbn"));
		
		//validate
		if(book1.getIsbn() == null) {
			insert(inputs);
		}else {
			update(inputs);
		}
		
		return book1;
	}
	
	public boolean delete(String id) {
		Book book1 = new Book();
		
		//find book
		book1 = book1.find(id);
		if(book1 == null) {
			JOptionPane.showMessageDialog(null, "Delete Failed!");
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Book Deleted!!");
			return book1.delete();
		}
	}
}
