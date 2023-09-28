package in.vaishnavi.controller;

import java.sql.*;

import in.vaishnavi.utility.JDBCUtil;

public class test {
	public static void main(String args[]) throws ClassNotFoundException{
		
		Connection conn = null;
		Statement stat = null;
		ResultSet res = null;
		
		try {
			conn = JDBCUtil.getDBConnection();
			if(conn!=null) {
				stat = conn.createStatement();
			}
			if(stat!=null) {
			   res = stat.executeQuery("Select * from teachers");	
			}
			if(res!=null) {
				while(res.next()) {
					System.out.println(res.getString(1)+ " " + res.getInt(2)+" " + res.getString(3));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.closeResources(res, stat, conn);
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
