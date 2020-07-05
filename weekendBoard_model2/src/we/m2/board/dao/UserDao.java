package we.m2.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import we.m2.board.util.ConnectHelper;
import we.m2.board.vo.User;

public class UserDao {
	
	private User resultSetToUser(ResultSet rs) throws SQLException {
		User user = new User();
		
		user.setNo(rs.getInt("user_no"));
		user.setId(rs.getString("user_id"));
		user.setPassword(rs.getString("user_password"));
		user.setName(rs.getString("user_name"));
		user.setEmail(rs.getString("user_email"));
		
		return user;
	}

	public void insertUser(User user) throws SQLException {
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "INSERT INTO users (user_id, user_name, user_password, user_email) VALUES (?, ?, ?, ?)";
		Object[] args = {user.getId(), user.getName(), user.getPassword(), user.getEmail()};
		
		PreparedStatement pstmt = ch.prepareQuery(con, sql, args);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public User getUserById(String userId) throws SQLException {
		User user = null; 
		
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "SELECT user_no, user_id, user_password, user_name, user_email FROM users WHERE user_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = resultSetToUser(rs);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
	}
}
