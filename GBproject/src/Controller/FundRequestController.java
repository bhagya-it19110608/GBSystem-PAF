package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBConnectionFund;
import Model.FundRequest;

public class FundRequestController {

	
	DBConnectionFund dbObj = new DBConnectionFund();
	
	public String viewRequstedFunds() {
		
		String output = "";
		
		FundRequest  f = new FundRequest();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
		}
			
		// Prepare the html table 
		output = "<table border=\"1\"><tr><th>ID</th>" + "<th>Reasercher ID</th>"
					+ "<th>Name</th><th>Email</th> "+" <th>Phone</th> "+" <th>Reaserch Name</th> "+"<th>Requesting Fund Amount</th></tr>";

		String query = "select * from fundrequest";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		// iterate through the rows in the result set
		while (rs.next()) {

			f.setId(rs.getInt("id"));
			f.setReasercherID(rs.getString("reasercherID"));
			f.setName(rs.getString("name"));
			f.setEmail(rs.getString("email"));
			f.setPhone(rs.getString("phone"));
			f.setReaserchName(rs.getString("reaserchName"));
			f.setRequestingAmount(rs.getDouble("requestingAmount"));
			
			// Add into the html table
			output += "<tr><td>" + f.getId() + "</td>";
			output += "<td>" + f.getReasercherID() + "</td>";
			output += "<td>" + f.getName() + "</td>";
			output += "<td>" + f.getEmail() + "</td>";
			output += "<td>" + f.getPhone() + "</td>";
			output += "<td>" + f.getReaserchName() + "</td>";
			output += "<td>" + f.getRequestingAmount()+ "</td>";
				
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
	
	
	public String addFundRequest(FundRequest f) {
		
		String output = "";
		
		try {

			Connection con = dbObj.connect();
				
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " INSERT INTO fundrequest (reasercherID, name, email, phone, reaserchName, requestingAmount) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, f.getReasercherID());
			preparedStmt.setString(2, f.getName());
			preparedStmt.setString(3, f.getEmail());
			preparedStmt.setString(4, f.getPhone());
			preparedStmt.setString(5, f.getReaserchName());
			preparedStmt.setDouble(6, f.getRequestingAmount());
			
				
				
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted a new fund request record successfully";

			} catch (Exception e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
	}
}
