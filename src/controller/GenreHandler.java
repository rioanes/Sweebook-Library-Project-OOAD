package controller;

import view.*;
import model.*;
import java.util.*;
import javax.swing.*;

public class GenreHandler {
	public JInternalFrame showManageGenreForm() {
		return new ManageGenreForm();
	}
	
	public List<Genre> getAll(){
		return new Genre().all();
	}
	
	public Genre insert(HashMap<String,String> inputs) {
		String id =  UUID.randomUUID().toString();
		
		Genre newGenre = new Genre(id, inputs.get("type"));
		return newGenre.insert();
	}
	
}


