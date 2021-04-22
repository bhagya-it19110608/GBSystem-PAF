
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBConnectionUser;
import Model.User;

public class UserController {

	DBConnectionUser dbObj = new DBConnectionUser();

	//view
	public String viewUsers() {

		String output = "";
		
		User  u = new User();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
		}
			
		// Prepare the html table 
		output = "<table border=\"1\"><tr><th>User Id</th>"
					+ "<th>First Name</th><th>Last Name</th> "+" <th>Email</th> "+" <th>Gender</th> "+" <th>Occupation</th> "+" <th>Phone</th> "+" <th>Username</th> "+" <th>Password</th> </tr>";

		String query = "select * from users";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		// iterate through the rows in the result set
		while (rs.next()) {

			u.setuId(rs.getInt("uId"));
			u.setfirstName(rs.getString("firstName"));
			u.setlastName(rs.getString("lastName"));
			u.setemail(rs.getString("email"));
			u.setgender(rs.getString("gender"));
			u.setoccupation(rs.getString("occupation"));
			u.setphone(rs.getString("phone"));
			u.setusername(rs.getString("username"));
			u.setpassword(rs.getString("password"));
			
			// Add into the html table
			output += "<tr><td>" + u.getuId() + "</td>";
			output += "<td>" + u.getfirstName() + "</td>";
			output += "<td>" + u.getlastName() + "</td>";
			output += "<td>" + u.getemail() + "</td>";
			output += "<td>" + u.getgender() + "</td>";
			output += "<td>" + u.getoccupation()+ "</td>";
			output += "<td>" + u.getphone()+ "</td>";
			output += "<td>" + u.getusername()+ "</td>";
			output += "<td>" + u.getpassword()+ "</td>";
				
			}
		
			con.close();
			
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the User Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	

	
	//insert	
	public String addUser(User u) {

		String output = "";
			
		try {

			Connection con = dbObj.connect();
				
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " INSERT INTO users (firstName,lastName,email,gender,occupation,phone,username,password) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, u.getfirstName());
			preparedStmt.setString(2, u.getlastName());
			preparedStmt.setString(3, u.getemail());
			preparedStmt.setString(4, u.getgender());
			preparedStmt.setString(5, u.getoccupation());
			preparedStmt.setString(6, u.getphone());
			preparedStmt.setString(7, u.getusername());
			preparedStmt.setString(8, u.getpassword());
				
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted a new User record successfully";

			} catch (Exception e) {
				output = "Error while inserting";
				System.err.println(e.getMessage());
			}

			return output;
		}
	

		//update
		public String updateUser(User u) {

			String output = "";

			try {
				Connection con = dbObj.connect();
				
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
					
				// create a prepared statement
				String query = "UPDATE users SET firstName=?,lastName=?,email=?,gender=?,occupation=?,phone=?,username=?,password=? WHERE uId =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				
				// binding values
				preparedStmt.setString(1, u.getfirstName());
				preparedStmt.setString(2, u.getlastName());
				preparedStmt.setString(3, u.getemail());
				preparedStmt.setString(4, u.getgender());
				preparedStmt.setString(5, u.getoccupation());
				preparedStmt.setString(6, u.getphone());
				preparedStmt.setString(7, u.getusername());
				preparedStmt.setString(8, u.getpassword());
				preparedStmt.setInt(9, u.getuId());
				
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully [ ID : "+u.getuId()+" ]";
				
				} catch (Exception e) {
					output = "Error while updating the User Id " + u.getuId();
					System.err.println(e.getMessage());
				}
				return output;
				
			}


		 	//delete
			public String deleteUser(User u) {
				
				String output = "";
				
				try {

					Connection con = dbObj.connect();
					
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "DELETE FROM users WHERE uId=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					 preparedStmt.setInt(1, u.getuId());
					
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Deleted successfully [ User Id : "+u.getuId()+" ]";

				} catch (Exception e) {

					output = "Error while deleting the  User Id :" + u.getuId();
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			
}
