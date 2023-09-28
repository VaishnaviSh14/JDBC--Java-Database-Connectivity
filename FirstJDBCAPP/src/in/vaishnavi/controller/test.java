package in.vaishnavi.controller;

import java.sql.*;

public class test {
	public static void main(String args[]) throws ClassNotFoundException ,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection
		String url = "jdbc:mysql://localhost:3306/VIPS";
		String user = "root";
		String password = "Vaishnavi1403";
		Connection connection = DriverManager.getConnection(url,user,password);
		
		//create a statement object
		Statement stat = connection.createStatement();
		
		//execute the query
//		String sqlselect = "Select * from teachers";
//		ResultSet res = stat.executeQuery(sqlselect);
		
//		//process the resultset
//		while(res.next()) {
//			System.out.println(res.getString(1)+ " " + res.getInt(2)+" " + res.getString(3));
//		}
		
		
		String insertquery = "Insert into teachers(tname , tsalary , tsubject) values('Neha' , 500000, 'java')";
		int rowaffected = stat.executeUpdate(insertquery);
		
		//process the result
		if(rowaffected ==1) {
			System.out.println("No. of rows affected " + rowaffected);
		}else {
			System.out.println("Not sucessfull in insertion ");
		}
		
		stat.close();

		
	}

}
