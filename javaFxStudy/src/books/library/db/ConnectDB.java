package books.library.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public static Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
