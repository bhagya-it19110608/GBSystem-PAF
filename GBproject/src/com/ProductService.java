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

import Controller.ProductController;
import Model.Product;

@Path("/product")
public class ProductService {

	ProductController pc = new ProductController();

	
	//get
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUser() {
		return pc.viewProducts();
	}


	//add
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN)
	public String enterProducts(String TypeData) {
		
		//check validation 
		
		try{
			if(TypeData == null) throw new Exception("Invaild Id");

			else {
		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
	
		Product r = new Product();
		
		r.setid(djosnObj.get("id").getAsInt());
		r.setname(djosnObj.get("name").getAsString());
		r.setcategory(djosnObj.get("category").getAsString());
		r.setdescription(djosnObj.get("description").getAsString());
		r.setprice(djosnObj.get("price").getAsDouble());
				
		// Read the values from the JSON object
		String output = pc.addProduct(r);
		return output;
			}
		}catch (Exception e){
			return "<p> Somethings went wrong <br/> ERROR -  "+ e.toString() +" </p>";
		}
	}



	
	
	
	//update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProducts(String TypeData) {

		//check validation 
		
		try{
			if(TypeData == null) throw new Exception("Invaild Id");

			else {
		// Convert the input string to a JSON object
		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
		Product r = new Product();

		r.setid(djosnObj.get("id").getAsInt());
		r.setname(djosnObj.get("name").getAsString());
		r.setcategory(djosnObj.get("category").getAsString());
		r.setdescription(djosnObj.get("description").getAsString());
		r.setprice(djosnObj.get("price").getAsDouble());
					
		String output = pc.updateProduct(r);
		return output;
			}
		}catch (Exception e){
			return "<p> Somethings went wrong <br/> ERROR -  "+ e.toString() +" </p>";
		}
	}
	

	//delete
		
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUsers(String TypeData) {
		
		//check validation 
		
		try{
			if(TypeData == null) throw new Exception("Invaild Id");

			else {
		// Convert the input string to a JSON object
		JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();

		Product r = new Product();
			
		// Read the value from the element <ID>
	   	r.setid(doc.get("id").getAsInt());
			
		String output = pc.deleteProduct(r);
		return output;
			}
		}catch (Exception e){
			return "<p> Somethings went wrong <br/> ERROR -  "+ e.toString() +" </p>";
		}
	}
}
