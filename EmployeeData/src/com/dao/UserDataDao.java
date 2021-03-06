package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.User;

public class UserDataDao {

	public List<User> getInfo() {
		Statement stmt = null;
		Connection conn = null;
		User usr= null;
		List<User> uslist= new ArrayList<>();
		try {
			usr= new User();
			DBConnection dbc = new DBConnection();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT * FROM employeedata.user";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usr= new User();
				usr.setEmpId(rs.getInt("empId"));
				usr.setEmpCode(rs.getString("empCode"));
				usr.setEmail(rs.getString("email"));
				usr.setStatus(rs.getString("status"));
				usr.setName(rs.getString("name"));
				uslist.add(usr);
				//System.out.println(rs.getInt("empId"));
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return uslist;
	}
}
