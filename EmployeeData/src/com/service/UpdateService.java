package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterUserDao;

@Path("/updateUser")
public class UpdateService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> updateUser(@FormParam("empCode") String empCode, @FormParam("eamil") String eamil,
			@FormParam("status") String status, @FormParam("name") String name) {
		List<String> loginResponse = new ArrayList<String>();
		try {

			RegisterUserDao obj = new RegisterUserDao();
		

				boolean statusTemp = obj.updateUser(empCode, eamil, status, name);
				if (statusTemp) {
					loginResponse.add("Details Updated");
					return loginResponse;
				}
				{
					loginResponse.add("Can't Update Details");
					return loginResponse;
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		loginResponse.add("Error Updating Details");
		return loginResponse;
	}

}
