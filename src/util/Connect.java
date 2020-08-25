package util;

import java.sql.*;


public class Connect {
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = 
					DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=&password=");
			return conn;
		}catch(Exception e) {
			
		}
		 return null;
	}
}
