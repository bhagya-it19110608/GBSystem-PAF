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

import Controller.FundController;
import Model.Fund;

@Path("/funds")
public class FundService {

	FundController fd = new FundController();

	
	//get
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFund() {
		return fd.viewFunds();
	}

	//getByID
	@GET
	@Path("/{idfund}")
	@Produces(MediaType.TEXT_HTML)
	public String readFundById(@PathParam("idfund") int idfund) {
		return fd.viewFundsById(idfund);
	}

	//add
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String enterFunds(String TypeData) {
		
		try {
			if(TypeData == null) throw new Exception("Invaild data type");
			else {
				// Convert the input string to a JSON object
				JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
			
				Fund f = new Fund();
				
				f.setProjectID(djosnObj.get("projectID").getAsString());
				f.setReasercherID(djosnObj.get("reasercherID").getAsString());
				f.setClientID(djosnObj.get("clientID").getAsString());
				f.setFundAmount(djosnObj.get("fundAmount").getAsDouble());
				f.setStatus(djosnObj.get("status").getAsString());
				
				// Read the values from the JSON object
				String output = fd.addFund(f);
				return output;
			}
		}catch(Exception e) {
			return "<p> Somethings went wrong <br/> ERROR -  "+ e.toString() +" </p>";
		}
		

	}

	
	
	
	//update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFunds(String TypeData) {

		try {
			if( TypeData == null ) throw  new Exception("Invalid data type");
			
			// Convert the input string to a JSON object
			JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
			Fund f = new Fund();

			f.setIdfund(djosnObj.get("idfund").getAsInt());
			f.setProjectID(djosnObj.get("projectID").getAsString());
			f.setReasercherID(djosnObj.get("reasercherID").getAsString());
			f.setClientID(djosnObj.get("clientID").getAsString());
			f.setFundAmount(djosnObj.get("fundAmount").getAsDouble());
			f.setStatus(djosnObj.get("status").getAsString());
				
				
			String output = fd.updateFund(f);
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
	public String deleteFunds(String TypeData) {
		try {
			if(TypeData == null ) throw new Exception("Invalid Id");
			// Convert the input string to a JSON object
			JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

			Fund f = new Fund();
				
			// Read the value from the element <ID>
		   	f.setIdfund(doc.get("idfund").getAsInt());
				
			String output = fd.deleteFund(f);
			return output;
		}catch(Exception e) {
			return "<p> Somethings went wrong <br> ERROR - "+e.toString()+ " </p>";
		}
		
		
	}
	
}
