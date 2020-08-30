package util;

import java.sql.*;


public class Connect {
	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sweebook","root","");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
