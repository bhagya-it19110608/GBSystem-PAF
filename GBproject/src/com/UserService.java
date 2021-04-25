package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

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
		try {
			if(TypeData == null) throw new Exception("Invaild data type");
			else {
				// Convert the input string to a JSON object
				JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
			
				User u = new User();
				
				u.setfirstName(djosnObj.get("firstName").getAsString());
				u.setlastName(djosnObj.get("lastName").getAsString());
				u.setemail(djosnObj.get("email").getAsString());
				u.setgender(djosnObj.get("gender").getAsString());
				u.setoccupation(djosnObj.get("occupation").getAsString());
				u.setphone(djosnObj.get("phone").getAsInt());
				u.setusername(djosnObj.get("username").getAsString());
				u.setpassword(djosnObj.get("password").getAsString());
				
				// Read the values from the JSON object
				String output = us.registerUser(u);
				return output;
			}
		}catch(Exception e) {
			return "<p> Somethings went wrong <br/> ERROR -  "+ e.toString() +" </p>";
		}
		

	}
	//login
	
		@POST
		@Path("/login")
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN)
		public String loginUsers(String TypeData) {
			// Convert the input string to a JSON object
			JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
		
			User auth = new User();
			
			
			auth.setemail(djosnObj.get("username").getAsString());
			auth.setpassword(djosnObj.get("password").getAsString());
		   
			// Read the values from the JSON object
		
			String output = us.loginUser(auth);
			return output;

		}
	
	
	//update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUsers(String TypeData) {
		
		try {
			if( TypeData == null ) throw  new Exception("Invalid data type");
			// Convert the input string to a JSON object
			JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
			User u = new User();

			u.setuId(djosnObj.get("uId").getAsInt());
			u.setfirstName(djosnObj.get("firstName").getAsString());
			u.setlastName(djosnObj.get("lastName").getAsString());
			u.setemail(djosnObj.get("email").getAsString());
			u.setgender(djosnObj.get("gender").getAsString());
			u.setoccupation(djosnObj.get("occupation").getAsString());
			u.setphone(djosnObj.get("phone").getAsInt());
			u.setusername(djosnObj.get("username").getAsString());
			u.setpassword(djosnObj.get("password").getAsString());
			
				
			String output = us.updateUser(u);
			return output;
		}catch(Exception e) {
			return "<p> Somethings went wrong <br> ERROR - "+e.toString()+" </p>";
		}

		
		
	}
	

	//delete
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUsers(String TypeData) {
		try {
			if(TypeData == null ) throw new Exception("Invalid Id");
			// Convert the input string to a JSON object
			JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

			User u = new User();
				
			// Read the value from the element <ID>
		   	u.setuId(doc.get("uId").getAsInt());
				
			String output = us.deleteUser(u);
			return output;
		}catch(Exception e) {
			return "<p> Somethings went wrong <br> ERROR - "+e.toString()+ " </p>";
		}
		
		
	}
	
	//filter
	@GET
	@Path("/{uId}")
	@Produces(MediaType.TEXT_HTML)
	public String viewUsersByID(@PathParam("uId")int uId) {
	return us.viewUsersByID(uId);
		}
	
}
