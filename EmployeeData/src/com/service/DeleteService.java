package com.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterUserDao;

@Path("/deleteUser")
public class DeleteService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteUser(@FormParam("empCode") String empCode)
	{
		RegisterUserDao usrDao = new RegisterUserDao();
		boolean tempStatus = false;
		tempStatus=usrDao.deleteUser(empCode);
		
			
		return tempStatus;
	}
}
