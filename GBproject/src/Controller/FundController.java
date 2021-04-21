package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBConnectionFund;
import Model.Fund;

public class FundController {

	DBConnectionFund dbObj = new DBConnectionFund();

	//view
	public String viewFunds() {

		String output = "";
		
		Fund  f = new Fund();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
		}
			
		// Prepare the html table 
		output = "<table border=\"1\"><tr><th>Fund ID</th>"
					+ "<th>Project ID</th><th>Reasercher ID</th> "+" <th>Client ID</th> "+" <th>Fund Amount</th> "+"<th>Status</th></tr>";

		String query = "select * from fund";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		// iterate through the rows in the result set
		while (rs.next()) {

			f.setIdfund(rs.getInt("idfund"));
			f.setProjectID(rs.getString("projectID"));
			f.setReasercherID(rs.getString("reasercherID"));
			f.setClientID(rs.getString("clientID"));
			f.setFundAmount(rs.getDouble("fundAmount"));
			f.setStatus(rs.getString("status"));
			
			// Add into the html table
			output += "<tr><td>" + f.getIdfund() + "</td>";
			output += "<td>" + f.getProjectID() + "</td>";
			output += "<td>" + f.getReasercherID() + "</td>";
			output += "<td>" + f.getClientID() + "</td>";
			output += "<td>" + f.getFundAmount() + "</td>";
			output += "<td>" + f.getStatus()+ "</td>";
				
			}
		
			con.close();
			
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Fund Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	

	
	//insert	
	public String addFund(Fund f) {

		String output = "";
			
		try {

			Connection con = dbObj.connect();
				
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " INSERT INTO fund (projectID, reasercherID, clientID, fundAmount, status) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, f.getProjectID());
			preparedStmt.setString(2, f.getReasercherID());
			preparedStmt.setString(3, f.getClientID());
			preparedStmt.setDouble(4, f.getFundAmount());
			preparedStmt.setString(5, f.getStatus());
				
				
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted a new fund record successfully";

			} catch (Exception e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
		}
	

		//update
		public String updateFund(Fund f) {

			String output = "";

			try {
				Connection con = dbObj.connect();
				
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
					
				// create a prepared statement
				String query = "UPDATE fund SET projectID=?,reasercherID=?,clientID=?,fundAmount=?,status=? WHERE idfund =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				
				// binding values
				preparedStmt.setString(1, f.getProjectID());
				preparedStmt.setString(2, f.getReasercherID());
				preparedStmt.setString(3, f.getClientID());
				preparedStmt.setDouble(4, f.getFundAmount());
				preparedStmt.setString(5, f.getStatus());
				preparedStmt.setInt(6, f.getIdfund());
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully [ ID : "+f.getIdfund()+" ]";
				
				} catch (Exception e) {
					output = "Error while updating the fund Id " + f.getIdfund();
					System.err.println(e.getMessage());
				}
				return output;
				
			}


		 	//delete
			public String deleteFund(Fund f) {
				
				String output = "";
				
				try {

					Connection con = dbObj.connect();
					
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "DELETE FROM fund WHERE idfund=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					 preparedStmt.setInt(1, f.getIdfund());
					
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Deleted successfully [ Fund Id : "+f.getIdfund()+" ]";

				} catch (Exception e) {

					output = "Error while deleting the  Fund Id :" + f.getIdfund();
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			
}
