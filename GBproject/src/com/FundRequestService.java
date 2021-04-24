package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Controller.FundRequestController;
import Model.FundRequest;

@Path("/fundrequest")
public class FundRequestService {

	FundRequestController fd = new FundRequestController();

	
	//get
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFundRequest() {
		return fd.viewRequstedFunds();
	}
	
	//add
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String enterFundRequest(String TypeData) {
		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
		
		FundRequest f = new FundRequest();
			
		f.setReasercherID(djosnObj.get("reasercherID").getAsString());
		f.setName(djosnObj.get("name").getAsString());
		f.setEmail(djosnObj.get("email").getAsString());
		f.setPhone(djosnObj.get("phone").getAsString());
		f.setReaserchName(djosnObj.get("reaserchName").getAsString());
		f.setRequestingAmount(djosnObj.get("requestingAmount").getAsDouble());
		
		// Read the values from the JSON object
		String output = fd.addFundRequest(f);
			return output;

		}
}
