package model;

import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import controller.*;
import model.*;


public class Member {
	private String id;
	private String address;
	private String memberSince;
	
	final String insertString = "INSERT INTO members (user_id,address,member_since) VALUES (?, ?, ?);";
	final String selectString = "SELECT * FROM members ORDER BY user_id DESC;";
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String id, String address, String memberSince) {
		super();
		this.id = id;
		this.address = address;
		this.memberSince = memberSince;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}
	
	public List<Member> all(){
		Connection connection = Connect.connect();
		List<Member> members = new ArrayList<Member>();
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(selectString);
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getString(1));
				member.setAddress(rs.getString(2));
				member.setMemberSince(rs.getString(3));
				
				
				members.add(member);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return members;
	}
	
	public Member insert() {
		Connection connection = Connect.connect();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertString);
			statement.setString(1, this.id);
			statement.setString(2, this.address);
			statement.setString(3, this.memberSince);
			
			statement.executeUpdate();
				
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return this;
	}
}
