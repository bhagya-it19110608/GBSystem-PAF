package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionOrder {

	public Connection connect() {
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/order", "root", "isira123");
			System.out.print("Successfully Connected");
			

		} catch (Exception e) {

			System.out.print("Connection Failed");
			e.printStackTrace();
			System.out.print(e);
		}

		return con;
	}
}
