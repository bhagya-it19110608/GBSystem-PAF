package com;




import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
	
	
	
	@GET
	@Path("/{userid}")
	@Produces(MediaType.TEXT_HTML)
	public String readByIdFromProposal(@PathParam("userid") int uid) {
		return pro.viewProposalById(uid);
	}
	

	// add types
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String enterType(String TypeData) {
		try {
			if(TypeData == null) throw new Exception("Invaild data type");
			else {
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
				pr.setUserid(djosnObj.get("userid").getAsInt());
				pr.setSummery(djosnObj.get("summery").getAsString());
				// Read the values from the JSON object
			
				String output = pro.addProposals(pr);
				return output;
			}
		}catch(Exception e) {
			return "<p> Somethings went wrong <br/> ERROR -  "+ e.toString() +" </p>";
		}
		

	}

	
	
	
	// update Types
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateAppType(String TypeData) {
			try {
				if( TypeData == null ) throw  new Exception("Invalid data type");
				
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
				pr.setUserid(djosnObj.get("userid").getAsInt());
				pr.setSummery(djosnObj.get("summery").getAsString());
				pr.setStatus(djosnObj.get("status").getAsString());
				
				String output = pro.updateProposal(pr);
				return output;
			}catch(Exception e) {
				return "<p> Somethings went wrong <br> ERROR - "+e.toString()+" </p>";
			}

			
		}
	
	
	


		// delete Types
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletetype(String TypeData) {
			try {
				if(TypeData == null ) throw new Exception("Invalid Id");
				// Convert the input string to a JSON object
				JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

//				JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
				proposal pr = new proposal();
				
				// Read the value from the element <ID>
		    	pr.setPid(doc.get("pid").getAsInt());
				//String id = doc.get("appointment_Id").getAsString();
				String output = pro.deleteProposals(pr);
				return output;
			}catch(Exception e) {
				return "<p> Somethings went wrong <br> ERROR - "+e.toString()+ " </p>";
			}
			
		}
	
}
