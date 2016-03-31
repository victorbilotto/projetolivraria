package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
private static Connection con;
	
	public static Connection getConnection(){
		try {
			if(con == null){
				Class.forName("com.mysql.jdbc.Driver");
			}			
			try {
				con = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=comicstore","root","01041994");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;		
	}
	
}
