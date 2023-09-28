package in.vaishnavi.controller;

import java.sql.*;
import java.util.Scanner;

import in.vaishnavi.utility.JDBCUtil;

public class SelectApp {
	public static void main(String args[]) throws ClassNotFoundException{
		
		Connection conn = null;
		Statement stat = null;
		ResultSet res = null;
		PreparedStatement ptsmt = null;
		Scanner sc = null;
		
		try {
			conn = JDBCUtil.getDBConnection();
			
			String sqlSelectQuery = "select * from teachers where tname =?";
			
			if(conn!=null) {
			   ptsmt = conn.prepareStatement(sqlSelectQuery);
			}
			
			if(ptsmt!=null) {
				
				 sc = new Scanner(System.in);
				
				System.out.println("Enter the value of tname :: ");
				String tname = sc.next();

				//setting the value for prepared statement
				ptsmt.setString(1, tname);

				
			res = ptsmt.executeQuery();
			
		}
			if(res!=null) {
				if(res.next()) {
					System.out.println("Tname\'Tsalary\'Tsubject");
					System.out.println(res.getString(1)+ " " + res.getInt(2)+" " + res.getString(3));
				}	
				}else {
					System.out.println("Record not available");
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.closeResources(res, ptsmt, conn);
				sc.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
