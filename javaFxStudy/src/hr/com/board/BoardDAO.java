package hr.com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hr.common.DAO;

public class BoardDAO {
	private static final BoardDAO singleton = new BoardDAO();
	private Connection conn;

	private BoardDAO() {
		conn = DAO.getConnect();
	}

	public static BoardDAO getInstance() {
		return singleton;
	}

	public void insertBoard(Board board) {
		System.out.println(board.toString());
		String sql = "insert into board (board_no, title, content, password, publicity, exit_date) "
				+ "values((select nvl(max(board_no), 0)+1 from board), ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getPassword());
			pstmt.setString(4, board.getPublicity());
			pstmt.setString(5, board.getExitDate());

			int r = pstmt.executeUpdate();
			System.out.println(r + " inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
