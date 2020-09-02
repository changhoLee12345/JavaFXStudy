package hr.control.tableView;

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

	public static ObservableList<Board> getBoardList() {
		conn = getConnect();

		String sql = "select * from board order by 1";
		ObservableList<Board> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("board_no"));
				System.out.println(rs.getString("title"));
				System.out.println(rs.getString("publicity"));
				System.out.println(rs.getString("exit_date"));
				System.out.println(rs.getString("content"));
				Board board = new Board(rs.getString("board_no"), rs.getString("title"), rs.getString("publicity"),
						rs.getString("exit_date"), rs.getString("content"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
