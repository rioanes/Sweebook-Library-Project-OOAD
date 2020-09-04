package controller;

import java.util.*;
import model.*;

public class UserHandler {
	public User insert(HashMap<String, String> inputs) {
		User user = new User();
		User.setId(inputs.get("id"));
		User.setRoleId(inputs.get("roleId"));
		user.setName(inputs.get("name"));
		user.setUsername(inputs.get("username"));
		user.setPassword(inputs.get("password"));
		user.setGender(inputs.get("gender"));
		
		return user.insert();
	}
	
	public User getByUsername(String username) {
		return new User().getByUsername(username);
	}
}
