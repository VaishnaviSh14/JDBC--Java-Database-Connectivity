package in.vaishnavi.controller;

import java.sql.*;
import java.util.Scanner;

import in.vaishnavi.utility.JDBCUtil;

public class DeleteApp {
	public static void main(String args[]) throws ClassNotFoundException{
		
		Connection conn = null;
		Statement stat = null;
		ResultSet res = null;
		PreparedStatement ptsmt = null;
		Scanner sc = null;
		
		try {
			conn = JDBCUtil.getDBConnection();
			
			String sqlDeleteQuery = "delete from teachers where tname =?";
			
			if(conn!=null) {
			   ptsmt = conn.prepareStatement(sqlDeleteQuery);
			}
			
			if(ptsmt!=null) {
				
				 sc = new Scanner(System.in);
				
				System.out.println("Enter the value of tname :: ");
				String tname = sc.next();
				

				
				//setting the value for prepared statement
				ptsmt.setString(1, tname);

				
				int rowaffected = ptsmt.executeUpdate();
				
				//process the result
				if(rowaffected ==1) {
					System.out.println("No. of rows affected " + rowaffected);
				}else {
					System.out.println("Record not available for deletion");
				}
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
