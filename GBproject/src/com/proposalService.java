package com;



import javax.websocket.server.PathParam;
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

import Controller.proposalController;

import Model.proposal;

@Path("/proposals")
public class proposalService {
	
	proposalController pro = new proposalController();

	
	// get all types for admin
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAllTypes() {
		return pro.viewProposals();
	}
	
	
	


	// add types
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String enterType(String TypeData) {
		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
	
		proposal pr = new proposal();
		
		pr.setPname(djosnObj.get("pname").getAsString());
		pr.setRname(djosnObj.get("rname").getAsString());
		pr.setCatagory(djosnObj.get("catagory").getAsString());
		pr.setDuration(djosnObj.get("duration").getAsString());
		pr.setEmail(djosnObj.get("email").getAsString());
		pr.setPhone(djosnObj.get("phone").getAsString());
		pr.setBudget(djosnObj.get("budget").getAsDouble());
		pr.setUserid(djosnObj.get("userid").getAsString());
		pr.setSummery(djosnObj.get("summery").getAsString());
		// Read the values from the JSON object
	
		String output = pro.addProposals(pr);
		return output;

	}

	
	
	
	// update Types
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateAppType(String TypeData) {

			// Convert the input string to a JSON object
			JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
			proposal pr = new proposal();

			pr.setPid(djosnObj.get("pid").getAsInt());
			pr.setPname(djosnObj.get("pname").getAsString());
			pr.setRname(djosnObj.get("rname").getAsString());
			pr.setCatagory(djosnObj.get("catagory").getAsString());
			pr.setDuration(djosnObj.get("duration").getAsString());
			pr.setEmail(djosnObj.get("email").getAsString());
			pr.setPhone(djosnObj.get("phone").getAsString());
			pr.setBudget(djosnObj.get("budget").getAsDouble());
			pr.setUserid(djosnObj.get("userid").getAsString());
			pr.setSummery(djosnObj.get("summery").getAsString());
			pr.setStatus(djosnObj.get("status").getAsString());
			
			String output = pro.updateProposal(pr);
			return output;
		}
	
	
	


		// delete Types
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletetype(String TypeData) {
			// Convert the input string to a JSON object
			JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

//			JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
			proposal pr = new proposal();
			
			// Read the value from the element <ID>
	    	pr.setPid(doc.get("pid").getAsInt());
			//String id = doc.get("appointment_Id").getAsString();
			String output = pro.deleteProposals(pr);
			return output;
		}
	
}
