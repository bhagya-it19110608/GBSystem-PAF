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

import Controller.OrderController;
import Model.Order;

@Path("/Order")
public class OrderService {

	OrderController oc = new OrderController();

	
	//get
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readOrder() {
		return oc.viewOrder();
	}


	//add
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String enterOrder(String TypeData) {
		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
	
		Order o = new Order();
		
		o.setOrderId(djosnObj.get("orderID").getAsInt());
		o.setOrderName(djosnObj.get("orderName").getAsString());
		o.setOrderategory(djosnObj.get("orderCategory").getAsString());
		o.setPaymentMethod(djosnObj.get("paymentMethod").getAsString());
		o.setOrderPayment(djosnObj.get("orderPayment").getAsDouble());;
		
		// Read the values from the JSON object
		String output = oc.addOrder(o);
		return output;

	}

	
	
	
	//update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateOrder(String TypeData) {

		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
		Order o = new Order();

		o.setOrderId(djosnObj.get("orderID").getAsInt());
		o.setOrderName(djosnObj.get("orderName").getAsString());
		o.setOrderategory(djosnObj.get("orderCategory").getAsString());
		o.setPaymentMethod(djosnObj.get("paymentMethod").getAsString());
		o.setOrderPayment(djosnObj.get("orderPayment").getAsDouble());
			
			
		String output = oc.updateOrder(o);
		return output;
		
	}
	

	//delete
		
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteOrder(String TypeData) {
		// Convert the input string to a JSON object
		JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

		Order o = new Order();
			
		// Read the value from the element <ID>
	   	o.setOrderId(doc.get("orderID").getAsInt());
			
		String output = oc.deleteOrder(o);
		return output;
		
	}
	
}
