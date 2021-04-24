package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBConnectionProduct;
import Model.Product;

public class ProductController {

	DBConnectionProduct dbObj = new DBConnectionProduct();
//view
	public String viewProducts() {

		String output = "";
		
		Product  r = new Product();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
		}
			
		// Prepare the html table 
		output = "<table border=\"1\"><tr><th>Product Id</th>"
					+ "<th>Product Name</th><th>Product Category</th> "+" <th>Description</th> "+" <th>Price</th></tr>";

		String query = "select * from product";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		// iterate through the rows in the result set
		while (rs.next()) {

			r.setid(rs.getInt("id"));
			r.setname(rs.getString("name"));
			r.setcategory(rs.getString("category"));
			r.setdescription(rs.getString("description"));
			r.setprice(rs.getDouble("price"));
			
			
			// Add into the html table
			output += "<tr><td>" + r.getid() + "</td>";
			output += "<td>" + r.getname() + "</td>";
			output += "<td>" + r.getcategory() + "</td>";
			output += "<td>" + r.getdescription() + "</td>";
			output += "<td>" + r.getprice() + "</td>";
			
			}
		
			con.close();
			
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Product Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	

	
	//insert	
	public String addProduct(Product r) {

		String output = "";
			
		try {

			Connection con = dbObj.connect();
				
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " INSERT INTO product (id,name,category,description,price) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, r.getid());
			preparedStmt.setString(2, r.getname());
			preparedStmt.setString(3, r.getcategory());
			preparedStmt.setString(4, r.getdescription());
			preparedStmt.setDouble(5, r.getprice());
			
			
				
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted a new Product successfully";

			} catch (Exception e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
		}
	

		//update
		public String updateProduct(Product r) {

			String output = "";

			try {
				Connection con = dbObj.connect();
				
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
					
				// create a prepared statement
				String query = "UPDATE product SET name=?,category=?,description=?,price=? WHERE id =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				
				// binding values
				preparedStmt.setString(1, r.getname());
				preparedStmt.setString(2, r.getcategory());
				preparedStmt.setString(3, r.getdescription());
				preparedStmt.setDouble(4, r.getprice());
				preparedStmt.setInt(5, r.getid());
								
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully [ ID : "+r.getid()+" ]";
				
				} catch (Exception e) {
					output = "Error while updating the Product Id " + r.getid();
					System.err.println(e.getMessage());
				}
				return output;
				
			}


		 	//delete
			public String deleteProduct(Product r) {
				
				String output = "";
				
				try {

					Connection con = dbObj.connect();
					
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "DELETE FROM product WHERE id=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					 preparedStmt.setInt(1, r.getid());
					
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Deleted successfully [ Product Id : "+r.getid()+" ]";

				} catch (Exception e) {

					output = "Error while deleting the  Product Id :" + r.getid();
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			
}
