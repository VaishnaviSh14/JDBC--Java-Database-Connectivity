package in.vaishnavi.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/VIPS";
		String user = "root";
		String password = "Vaishnavi1403";
		
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void closeResources(ResultSet res , Statement stat , Connection conn) throws SQLException {
		if(res!=null) 
			res.close();
		
		if(stat!=null) 
			stat.close();
		
		if(conn!=null) 
			conn.close();
		
	}
}
