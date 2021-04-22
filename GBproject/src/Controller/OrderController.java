package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBConnectionOrder;
import Model.Order;

public class OrderController {

	DBConnectionOrder dbObj = new DBConnectionOrder();

	//view
	public String viewOrder() {

		String output = "";
		
		Order  o = new Order();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
		}
			
		// Prepare the HTML table 
		output = "<table border=\"1\"><tr><th>Order ID</th>"
					+ "<th>Order Name</th><th>Order Category</th> "+" <th>Payment Method</th> "+" <th>Order Payment</th></tr>";

		String query = "SELECT * FROM order_tb";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		// iterate through the rows in the result set
		while (rs.next()) {

			o.setOrderId(rs.getInt("orderID"));
			o.setOrderName(rs.getString("orderName"));
			o.setOrderategory(rs.getString("orderCategory"));
			o.setPaymentMethod(rs.getString("paymentMethod"));
			o.setOrderPayment(rs.getDouble("orderPayment"));
			
			// Add into the HTML table
			output += "<tr><td>" + o.getOrderId() + "</td>";
			output += "<td>" + o.getOrderName() + "</td>";
			output += "<td>" + o.getOrderCategory() + "</td>";
			output += "<td>" + o.getPaymentMethod() + "</td>";
			output += "<td>" + o.getOrderPayment() + "</td>";
				
			}
		
			con.close();
			
			// Complete the HTML table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Order Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	

	
	//insert	
	public String addOrder(Order o) {

		String output = "";
			
		try {

			Connection con = dbObj.connect();
				
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " INSERT INTO order_tb (orderID, orderName, orderCategory, paymentMethod, orderPayment) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, o.getOrderId());
			preparedStmt.setString(2, o.getOrderName());
			preparedStmt.setString(3, o.getOrderCategory());
			preparedStmt.setString(4, o.getPaymentMethod());
			preparedStmt.setDouble(5, o.getOrderPayment());
				
				
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted a new order record successfully";

			} catch (Exception e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
		}
	

		//update
		public String updateOrder(Order o) {

			String output = "";

			try {
				Connection con = dbObj.connect();
				
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
					
				// create a prepared statement
				String query = "UPDATE order_tb SET orderName=?,orderCategory=?,paymentMethod=?,orderPayment=? WHERE orderID =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				
				// binding values
				preparedStmt.setInt(5, o.getOrderId());
				preparedStmt.setString(1, o.getOrderName());
				preparedStmt.setString(2, o.getOrderCategory());
				preparedStmt.setString(3, o.getPaymentMethod());
				preparedStmt.setDouble(4, o.getOrderPayment());
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully [ ID : "+o.getOrderId()+" ]";
				
				} catch (Exception e) {
					output = "Error while updating the order Id " + o.getOrderId();
					System.err.println(e.getMessage());
				}
				return output;
				
			}


		 	//delete
			public String deleteOrder(Order o) {
				
				String output = "";
				
				try {

					Connection con = dbObj.connect();
					
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "DELETE FROM order_tb WHERE orderID=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					 preparedStmt.setInt(1, o.getOrderId());
					
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Deleted successfully [ Order Id : "+o.getOrderId()+" ]";

				} catch (Exception e) {

					output = "Error while deleting the  Order Id :" + o.getOrderId();
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			
}
