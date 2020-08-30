package controller;

import java.util.*;
import model.*;

public class RoleHandler {
	public List<Role> getAll(){
		return new Role().all();
	}
	
	public Role getByName(String name) {
		return new Role().getByName(name);
	}
}
