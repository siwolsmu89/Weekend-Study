package com.hackers.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ConnectHelper {
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mariadb://서버명 또는 ip:포트번호:db명";
		String user = "hackers";
		String password = "zxcv1234";
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public PreparedStatement prepareSelect(Connection connection, String sql, Object[] args) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(sql);
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
		
		return pstmt;
	}
}
