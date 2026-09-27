package Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class Mysql_Connection1{
  public final String DB_URL="jdbc:mysql://localhost:3306/uni";
  public final String USER="root";
  public final String PASS="goodluck"

  public Connection myconnect() throws Exception{
    Connection conn=null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Connecting to mysql database");
      conn=DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Connection success");
    }
    catch(Exception e){
      System.out.println(e);
    }
    return conn;
  }
}
    


