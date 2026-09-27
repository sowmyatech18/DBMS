package Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//write code to connect with MySQL database and fetch data from table
class MySQL_Connection1 {
	public final String DB_URL = "jdbc:mysql://localhost:3306/uni";
	public final String USER = "root";
	public final String PASS = "goodluck";

	public Connection myConnect() throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to the MySQL database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection successful!");

		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}

public class mysql2 {

	public static void main(String[] args) throws Exception {

		MySQL_Connection1 obj = new MySQL_Connection1();
		Connection conn = obj.myConnect();
		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();
		String sql = "SELECT bid,title FROM book";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int bid = rs.getInt("bid");
			String title = rs.getString("title");

			System.out.print("bid: " + bid+" ");
			System.out.print("Title: " + title);
			System.out.println();
		}
		if (conn != null) {
			conn.close();
			System.out.println("Connection closed.");
		}
	}
}
