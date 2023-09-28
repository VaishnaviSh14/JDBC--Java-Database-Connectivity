package in.vaishnavi.controller;

import java.sql.*;
import java.util.Scanner;

import in.vaishnavi.utility.JDBCUtil;

public class InsertApp {
	public static void main(String args[]) throws ClassNotFoundException{
		
		Connection conn = null;
		Statement stat = null;
		ResultSet res = null;
		PreparedStatement ptsmt = null;
		Scanner sc = null;
		
		try {
			conn = JDBCUtil.getDBConnection();
			
			String sqlInsertQuery = "insert into teachers(tname , tsalary , tsubject)values(?,?,?)";
			
			if(conn!=null) {
			   ptsmt = conn.prepareStatement(sqlInsertQuery);
			}
			
			if(ptsmt!=null) {
				
				 sc = new Scanner(System.in);
				
				System.out.println("Enter the value of tname :: ");
				String tname = sc.next();
				
				System.out.println("Enter the value of tsalary :: ");
				int tsalary = sc.nextInt();
				
				System.out.println("Enter the value of tsubject :: ");
				String tsubject = sc.next();
				
				//setting the value for prepared statement
				ptsmt.setString(1, tname);
				ptsmt.setInt(2, tsalary);
				ptsmt.setString(3, tsubject);
				
				int rowaffected = ptsmt.executeUpdate();
				
				//process the result
				if(rowaffected ==1) {
					System.out.println("No. of rows affected " + rowaffected);
				}else {
					System.out.println("Not sucessfull in insertion ");
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
