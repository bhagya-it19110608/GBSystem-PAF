package Controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.proposal;
import DBUtil.DBConnection;




public class proposalController {
	
	DBConnection dbObj = new DBConnection();

	
	
	
	public String viewProposals() {

		String output = "";
		
		proposal  pr = new proposal();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>ProposalID</th>"
					+ "<th>ProposalName</th><th>ResearcherName</th> "+" <th>Catagory</th> "+"<th>Duration</th> "+" <th>Email</th> "+" <th>Phone</th> "+" <th>Budget</th> "+" <th>Summery</th>" + "<th>Update</th><th>Delete</th></tr>";

			String query = "select * from proposals";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				pr.setPid(rs.getInt("pid"));
				pr.setPname(rs.getString("pname"));
				pr.setRname(rs.getString("rname"));
				pr.setCatagory(rs.getString("catagory"));
				pr.setDuration(rs.getString("duration"));
				pr.setEmail(rs.getString("email"));
				pr.setPhone(rs.getString("phone"));
				pr.setBudget(rs.getDouble("budget"));
				pr.setSummery(rs.getString("summery"));

				// Add into the html table
				output += "<tr><td>" + pr.getPid() + "</td>";
				output += "<td>" + pr.getPname() + "</td>";
				output += "<td>" + pr.getRname() + "</td>";
				output += "<td>" + pr.getCatagory() + "</td>";
				output += "<td>" + pr.getDuration() + "</td>";
				output += "<td>" + pr.getEmail()+ "</td>";
				output += "<td>" + pr.getPhone()+ "</td>";
				output += "<td>" + pr.getBudget()+ "</td>";
				output += "<td>" + pr.getSummery()+ "</td>";
				
				String pid = null;
				// buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
				 + "<td>"
				 + "<input name='btnDelete' type='submit' value='Delete' class='btn btn-danger'>"
				 + "<input name='pid' type='hidden' value='" + pid + "'>" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Proposal Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	

	
		
	public String addProposals(proposal  pr) {

			String output = "";
			try {

				Connection con = dbObj.connect();
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = " INSERT INTO proposals (pname,rname, catagory,duration, email,phone,budget,summery) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setString(1, pr.getPname());
				preparedStmt.setString(2, pr.getRname());
				preparedStmt.setString(3, pr.getCatagory());
				preparedStmt.setString(4, pr.getDuration());
				preparedStmt.setString(5, pr.getEmail());
				preparedStmt.setString(6, pr.getPhone());
				preparedStmt.setDouble(7, pr.getBudget());
				preparedStmt.setString(8, pr.getSummery());
				
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";

			} catch (Exception e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
		}
	
	
	
		
		
	
			public String updateProposal(proposal pr) {

				String output = "";

				try {
					Connection con = dbObj.connect();
					if (con == null) {
						return "Error while connecting to the database for updating.";
					}
					// create a prepared statement
					String query = "UPDATE proposals SET pname=?,rname=?,catagory=?,duration=?,email=?,phone=?,budget=?,summery=? WHERE pid =?";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values

					preparedStmt.setString(1, pr.getPname());
					preparedStmt.setString(2, pr.getRname());
					preparedStmt.setString(3, pr.getCatagory());
					preparedStmt.setString(4, pr.getDuration());
					preparedStmt.setString(5, pr.getEmail());
					preparedStmt.setString(6, pr.getPhone());
					preparedStmt.setDouble(7, pr.getBudget());
					preparedStmt.setString(8, pr.getSummery());
					preparedStmt.setInt(9, pr.getPid());
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Updated successfully [ ID : "+pr.getPid()+" ]";
				} catch (Exception e) {
					output = "Error while updating the Proposal Id " + pr.getPid();
					System.err.println(e.getMessage());
				}
				return output;
			}


			
			
			public String deleteProposals(proposal pr) {
				String output = "";
				try {

					Connection con = dbObj.connect();
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "DELETE FROM proposals WHERE pid=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					 preparedStmt.setInt(1, pr.getPid());
					//preparedStmt.setInt(4, appBean.getAppointment_Id());
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Deleted successfully [ Proposal Id : "+pr.getPid()+" ]";

				} catch (Exception e) {

					output = "Error while deleting the  Proposal Id :" + pr.getPid();
					System.err.println(e.getMessage());
				}

				return output;
			}
			
	
			
			

			
			
			
			
			
			
			
			
			
}