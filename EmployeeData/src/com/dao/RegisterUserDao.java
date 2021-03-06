package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pojo.User;

public class RegisterUserDao {

	// register new user details
	public boolean registerNewUser(String empCode, String email, String status, String name) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		UserDataDao checkData = new UserDataDao();
		String tempCode = null ;
		for(int i=0;i<checkData.getInfo().size();i++)
		{
			tempCode = checkData.getInfo().get(i).getEmpCode();
			
		}
		if(tempCode != empCode) {
		try {
			DBConnection dbc = new DBConnection();
			conn = dbc.getDBConnection();

			stmt = conn.createStatement();

			String sql = "INSERT INTO `employeedata`.`user` (`empCode`, `email`, `status`, `name`) VALUES ('"+ empCode +"','"  + email +"','" + status +"','" + name +"')";


			stmt.executeUpdate(sql);
			return true;

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
		}
		else
		{
			return false;
		}
		return false;
	
	}
	// update user
	
	public boolean updateUser(String empCode, String email, String status, String name) {
		// TODO Auto-generated method stub
		boolean tempStatus=false;
		try {
		
			DBConnection dbc = new DBConnection();
			//Connection conn = dbc.getDBConnection();
			
			PreparedStatement ps;
			

		
			ps= dbc.getDBConnection().prepareStatement("UPDATE `employeedata`.`user` SET `name`=?,`email`=?,`status`=? WHERE `empCode` = ? ");
			
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, status);
			ps.setString(4, empCode);
			
			
			if(ps.executeUpdate()>0) {
				tempStatus= true;
			}
				
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempStatus;
	}
	
	// Delete user
	
	public boolean deleteUser(String empCode) {
		// TODO Auto-generated method stub
		boolean tempStatus=false;
		try {
		
			DBConnection dbc = new DBConnection();
			//Connection conn = dbc.getDBConnection();
			
			PreparedStatement ps;
			

		
			ps= dbc.getDBConnection().prepareStatement("DELETE FROM `employeedata`.`user` WHERE `empCode` = ? ");
			
			
	
			ps.setString(1, empCode);
			
			
			if(ps.executeUpdate()>0) {
				tempStatus= true;
			}
				
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempStatus;
	}
	
	public User fetchUserDetailsByUserIdPassword(String userName, String pass) {
		Statement stmt = null;
		Connection conn = null;
		User usr= null;
		try {
			usr= new User();
			DBConnection dbc = new DBConnection();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT empCode, email, status, name FROM employeedata.user where name = '" + userName + "' and password = '" + pass +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			//	usr.setEmpId(rs.getInt("empId"));
				usr.setEmpCode(rs.getString("empCode"));
				usr.setEmail(rs.getString("email"));
				usr.setStatus(rs.getString("status"));
				usr.setName(rs.getString("name"));
		        
		    }
			return usr;

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
		return usr;
	}

	public Integer checkUseIsExistsbyUserName(String empCode) {
		Statement stmt = null;
		Connection conn = null;
		Integer resultRecord = 0;
		try {
			
			DBConnection dbc = new DBConnection();
			conn = dbc.getDBConnection();
			

			stmt = conn.createStatement();

			String sql = "SELECT empId, empCode, email, status, name FROM employeedata.user where empCode = '" + empCode + "'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				resultRecord++;
		    }
			return resultRecord;

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
		return resultRecord;
	}
}
