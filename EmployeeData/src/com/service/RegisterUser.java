package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterUserDao;



@Path("/registerUser")
public class RegisterUser {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> registerNewUser(@FormParam("empCode") String empCode, @FormParam("eamil") String eamil,
			@FormParam("status") String status, @FormParam("name") String name) {
		List<String> loginResponse = new ArrayList<String>();
		Integer userRecord = 0;
		try {
			if(empCode==null || eamil== null ||status==null || name==null) {
				loginResponse.add("Fill all details");
			}
			else {
			RegisterUserDao obj = new RegisterUserDao();
			userRecord = obj.checkUseIsExistsbyUserName(empCode);
			if (userRecord == 0) {

				boolean statusTemp = obj.registerNewUser(empCode, eamil, status, name);
				if (statusTemp) {
					loginResponse.add("User sucessfully created");
					return loginResponse;
				}
				{
					loginResponse.add("User Creation fail");
					return loginResponse;
				}
			} else {
				loginResponse.add("Employee Code Already Exists. Must be unique");
				return loginResponse;
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		loginResponse.add("User Creation fail");
		return loginResponse;
	}

}

