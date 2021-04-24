package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Controller.UserController;
import Model.User;

@Path("/user")
public class UserService {

	UserController us = new UserController();

	
	//get
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUser() {
		return us.viewUsers();
	}


	//register
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String enterUsers(String TypeData) {
		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
	
		User u = new User();
		
		u.setfirstName(djosnObj.get("firstName").getAsString());
		u.setlastName(djosnObj.get("lastName").getAsString());
		u.setemail(djosnObj.get("email").getAsString());
		u.setgender(djosnObj.get("gender").getAsString());
		u.setoccupation(djosnObj.get("occupation").getAsString());
		u.setphone(djosnObj.get("phone").getAsString());
		u.setusername(djosnObj.get("username").getAsString());
		u.setpassword(djosnObj.get("password").getAsString());
		
		// Read the values from the JSON object
		String output = us.registerUser(u);
		return output;

	}
	//login
	
		@POST
		@Path("/login")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String loginUsers(String TypeData) {
			// Convert the input string to a JSON object
			JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

			User u = new User();
				
			// Read the value from the element <ID>
			u.setusername(doc.get("username").getAsString());
			
			String output = us.loginUser(u);
			return output;
			
		}
	
	
	//update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUsers(String TypeData) {

		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
		User u = new User();

		u.setuId(djosnObj.get("uId").getAsInt());
		u.setfirstName(djosnObj.get("firstName").getAsString());
		u.setlastName(djosnObj.get("lastName").getAsString());
		u.setemail(djosnObj.get("email").getAsString());
		u.setgender(djosnObj.get("gender").getAsString());
		u.setoccupation(djosnObj.get("occupation").getAsString());
		u.setphone(djosnObj.get("phone").getAsString());
		u.setusername(djosnObj.get("username").getAsString());
		u.setpassword(djosnObj.get("password").getAsString());
		
			
		String output = us.updateUser(u);
		return output;
		
	}
	

	//delete
		
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUsers(String TypeData) {
		// Convert the input string to a JSON object
		JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

		User u = new User();
			
		// Read the value from the element <ID>
	   	u.setuId(doc.get("uId").getAsInt());
			
		String output = us.deleteUser(u);
		return output;
		
	}
	
}
