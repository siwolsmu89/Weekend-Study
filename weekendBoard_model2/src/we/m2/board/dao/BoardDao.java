package we.m2.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import we.m2.board.util.ConnectHelper;
import we.m2.board.vo.Board;

public class BoardDao {

	public void insertBoard(Board board) throws SQLException {
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "INSERT INTO boards (board_title_header, board_title, user_name, board_content, board_image_src, board_file_src) VALUES (?, ?, ?, ?, ?, ?)";
		Object[] args = {board.getTitleHeader(), board.getTitle(), board.getUserName(), board.getContent(), board.getImageSrc(), board.getFileSrc()};
		PreparedStatement pstmt = ch.prepareQuery(con, sql, args);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void updateBoard(Board board) throws SQLException {
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "UPDATE boards SET board_title_header = ?, board_title = ?, board_content = ?, board_del_yn, board_notice_yn, board_view_count = ?, board_image_src = ?, board_file_src = ? WHERE board_no = ?";
		Object[] args = {board.getTitleHeader(), board.getTitle(), board.getContent(), board.isDeleted(), board.isNotice(), board.getViewCount(), board.getImageSrc(), board.getFileSrc(), board.getNo()};
		PreparedStatement pstmt = ch.prepareQuery(con, sql, args);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void deleteBoard(int boardNo) throws SQLException {
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "DELETE FROM boards WHERE board_no = ?";
		Object[] args = {boardNo};
		PreparedStatement pstmt = ch.prepareQuery(con, sql, args);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public Board resultSetToBoard(ResultSet rs) throws SQLException {
		Board board = new Board();
		
		board.setNo(rs.getInt("board_no"));
		board.setTitleHeader(rs.getString("board_title_header"));
		board.setTitle(rs.getString("board_title"));
		board.setUserName(rs.getString("user_name"));
		board.setViewCount(rs.getInt("board_view_count"));
		board.setRegDate(rs.getDate("board_reg_date"));
		board.setDeleted((rs.getString("board_del_yn").equalsIgnoreCase("Y") ? true : false));
		board.setNotice((rs.getString("board_notice_yn").equalsIgnoreCase("Y") ? true : false));
		board.setContent(rs.getString("board_content"));
		board.setImageSrc(rs.getString("board_image_src"));
		board.setFileSrc(rs.getString("board_file_src"));
		
		return board;
	}
	
	public int getBoardCount() throws SQLException {
		int count = -1;
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "SELECT COUNT(*) AS CNT FROM boards";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("CNT");
		}
		
		
		return count;
	}
	
	public Board getBoardByNo(int boardNo) throws SQLException {
		Board board = null;
		
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "SELECT * FROM boards WHERE board_no = ?";
		Object[] args = {boardNo};
		PreparedStatement pstmt = ch.prepareQuery(con, sql, args);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			board = resultSetToBoard(rs);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return board;
	}
	
	public List<Board> getBoardsByRange(int begin, int end) throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		ConnectHelper ch = new ConnectHelper();
		Connection con = ch.getConnection();
		String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY board_no DESC) AS RN FROM boards) B WHERE RN BETWEEN ? AND ?";
		Object[] args = {begin, end};
		PreparedStatement pstmt = ch.prepareQuery(con, sql, args);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Board board = resultSetToBoard(rs);
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return boards;
	}
}
