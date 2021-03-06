package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pojo.LoginRes;
import com.pojo.User;

@Path("/login")
public class LoginService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<LoginRes> getInfo(@FormParam("param1") String user,@FormParam("param2") String pass)
	{
		List<LoginRes> loginResponse = new ArrayList<LoginRes>();
		LoginRes lr= new LoginRes();
		User UserDtl = new User();
		if(!user.equals("")&& !pass.equals(""))
			
		{
			if(user.equals("admin") && pass.equals("123"))
			{
				lr.setStatus("sucess");
        		
        		lr.setUserName(UserDtl.getName());
        		lr.setData("Sucessfully Login");
        		loginResponse.add(lr);
        		return loginResponse;
    			
    		}
			else {
    			lr.setStatus("fail");
        		lr.setData("User name and password Not Valid");
        		loginResponse.add(lr);
        		return loginResponse;
    		}
			
			
    	}else {
    		lr.setStatus("fail");
    		
    		lr.setData("User name and password should not blank");
    		loginResponse.add(lr);
    		return loginResponse;
    	}
    	
		
	}
		
	}
	


