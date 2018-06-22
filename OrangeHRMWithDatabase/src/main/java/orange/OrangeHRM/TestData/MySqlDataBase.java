package orange.OrangeHRM.TestData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDataBase {
	// Connection Object
	static Connection con = null;
	// Statement Object
	static Statement stmt = null;
	// Data Base Url
	static String DB_URL = "jdbc:mysql://localhost:3306/selenium";
	// Data base Class
	static String DB_Class = "com.mysql.cj.jdbc.Driver";
	// Data base UserName
	static String DB_username = "root";
	// Data base Password
	static String DB_password = "Keerthan#001";

	public Statement DBConnect() throws Exception {

		try {
			// Make Data base connection
			Class.forName(DB_Class).newInstance();
			con = DriverManager.getConnection(DB_URL, DB_username, DB_password);
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Unable to Connect DataBase");
			e.printStackTrace();
		}
		return stmt;
	}

	public void DBClose() throws SQLException {
		// Close the DB Connection
		if (con != null)
			con.close();
	}

}
