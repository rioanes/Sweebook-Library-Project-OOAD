package controller;

import javax.swing.*;
import java.util.*;
import model.*;
import view.CreateMembershipForm;

public class MemberHandler {
	public JFrame showCreateMembershipForm() {
		return new CreateMembershipForm();
	}
	
	public JInternalFrame showViewMembershipForm() {
		return showViewMembershipForm();
	}
	
	public List<Member> getAll(){
		return new Member().all();
	}
	
	public Member insert(HashMap<String, String> inputs) {
		
	}
}
