package Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//Transactions in MySQL
class MySQL_Connection {
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
			 conn.setAutoCommit(false); // add auto commit to false

		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}

public class mysql3{

	public static void main(String[] args) throws Exception {

		MySQL_Connection obj = new MySQL_Connection();
		Connection conn = obj.myConnect();

		String sql = "SELECT bid,title FROM book";		
		String sql1="INSERT INTO book (bid,title,auth,pub,pubyr,price,noc) VALUES (?, ?, ?, ?, ?, ?,?)";
		
		System.out.println("Creating statement...");
		PreparedStatement stmt = conn.prepareStatement(sql1);
		stmt.setInt(1, 106);
		stmt.setString(2, "Lover");
		stmt.setString(3, "lana");
		stmt.setString(4,"del");
		stmt.setInt(5, 2020);
		stmt.setDouble(6,1500);
		stmt.setInt(7,350);
		
		int rs = stmt.executeUpdate();
		System.out.println("Record Inserted: "+rs);
		conn.commit(); // Commit once the transaction is done
        System.out.println("Transaction committed successfully.");
			
	}
}
