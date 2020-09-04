package hr.control.tableView.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDAO {

	static Connection conn = null;

	public static Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void updateBoard(Board board) {
		conn = getConnect();
		String sql = "update board set password = ? , publicity = ? , exit_date = ? , content = ? where title = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getPassword());
			pstmt.setString(2, board.getPublicity());
			pstmt.setString(3, board.getExitDate());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getTitle());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Board getBoard(String title) {
		conn = getConnect();
		String sql = "select * from board where title = ? and rownum = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board board = new Board(rs.getString("title"), rs.getString("password"), rs.getString("publicity"),
						rs.getString("exit_date"), rs.getString("content"));
				return board;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void insertBoard(Board board) {
		conn = getConnect();
		System.out.println(board.getExitDate());
		String sql = "insert into board values((select max(board_no) +1 from board), ?,?,?,?,?,null)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getPassword());
			pstmt.setString(4, board.getPublicity());
			pstmt.setString(5, board.getExitDate());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ObservableList<Board> getBoardList() {
		conn = getConnect();

		String sql = "select * from board order by 1";
		ObservableList<Board> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
//				System.out.println(rs.getString("board_no"));
//				System.out.println(rs.getString("title"));
//				System.out.println(rs.getString("publicity"));
//				System.out.println(rs.getString("exit_date"));
//				System.out.println(rs.getString("content"));
				Board board = new Board(rs.getString("title"), rs.getString("password"), rs.getString("publicity"),
						rs.getString("exit_date"), rs.getString("content"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
