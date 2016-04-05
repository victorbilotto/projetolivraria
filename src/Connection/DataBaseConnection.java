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
				String serverName = "216.172.172.167:3306"; //caminho do servidor do BD
			    String mydatabase = "bmedi691_projetolivraria"; //nome banco de dados 
			    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
			    String username = "bmedi691_pluser"; //nome de usuário do BD 
			    String password = "a123456"; //senha de acesso 
			    con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;		
	}
	
	
	
}
