package com.hackers.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ConnectionUtil {
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static Connection connection;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	private static void getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hackers";
		String password = "zxcv1234";
		
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public static ResultSet selectHandler(String sql, Object[] args) throws SQLException {
		getConnection();
		pstmt = connection.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			String className = args[i].getClass().getName();
			if ("java.lang.Integer".equals(className)) {
				pstmt.setInt(i + 1, (int) args[i]); 
			}
			
			if ("java.lang.String".equals(className)) {
				pstmt.setString(i + 1, (String) args[i]);
			}
			
			if ("java.util.Date".equals(className)) {
				Date argDate = (Date) args[i];
				pstmt.setDate(i + 1, new java.sql.Date(argDate.getTime()));
			}
		}
		
		rs = pstmt.executeQuery();
		
		return rs;
	}
	
	public static void 
	
	public static void closeResources() throws SQLException {
		rs.close();
		pstmt.close();
		connection.close();
	}
	
	public static void main(String[] args) {
		String test = "test";
		int int1 = 1;
		Object t2 = test;
		Object t1 = int1;
		Date date = new Date();
		Object t3 = date;
		
		System.out.println(t3.getClass().getName());
		System.out.println(t1.getClass().getName());
		System.out.println(t2.getClass().getName());
	}
}
