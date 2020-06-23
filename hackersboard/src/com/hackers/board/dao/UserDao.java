package com.hackers.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hackers.board.util.ConnectHelper;
import com.hackers.board.vo.User;

public class UserDao {

	public void insertUser(User user) throws SQLException {
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "INSERT INTO users (user_no, user_id, user_name, user_password, user_email) VALUES (user_no_seq.NEXTVAL, ?, ?, ?, ?)";
		Object[] args = {user.getId(), user.getName(), user.getPassword(), user.getEmail()};
		
		PreparedStatement pstmt = ch.prepareSelect(con, sql, args);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}
