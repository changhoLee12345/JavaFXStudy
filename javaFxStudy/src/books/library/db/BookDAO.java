package books.library.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import books.library.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookDAO {
	static PreparedStatement pstmt;
	static ResultSet rs;
	static Connection conn;

	public static void insertBook(Book book) {
		String sql = "insert into book(book_title,author,press,press_date,price,isbn) values(?,?,?,?,?,?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPress());
			pstmt.setString(4, book.getPressDate());
			pstmt.setInt(5, book.getPrice());
			pstmt.setString(6, book.getIsbn());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력됨.");

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

	public static ObservableList<Book> getBookList() {
		conn = ConnectDB.getConnect();
		ObservableList<Book> list = FXCollections.observableArrayList();

		String sql = "select book_title, author, press, press_date, price, isbn from book order by 1";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_title"), rs.getString("author"), rs.getString("press"),
						rs.getString("press_date"), rs.getInt("price"), rs.getString("isbn"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
