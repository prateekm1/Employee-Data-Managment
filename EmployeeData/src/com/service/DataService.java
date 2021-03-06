package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.UserDataDao;
import com.pojo.User;

@Path("/data")
public class DataService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> usrData ()
	{
		List<User> userData = new ArrayList<User>();
	
		UserDataDao empinfo = new UserDataDao();
		
		userData = empinfo.getInfo();
		
		//userData.add(usrdt);
	//	System.out.println(userData);
		return userData;
	
		
	}
}
