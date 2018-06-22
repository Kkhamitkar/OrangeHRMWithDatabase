package orangeHRM.TestCases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import orange.OrangeHRM.Pages.HomePage;
import orange.OrangeHRM.Pages.Login;
import orange.OrangeHRM.TestBase.TestBase;
import orange.OrangeHRM.TestData.MySqlDataBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC6_Delete_UsersTest extends TestBase {
	Login Lp;
	HomePage Hp;
	MySqlDataBase MDB,MDBD;
	Statement stmt,stmtd;
	String Query,DQuery;
	ResultSet res;
	boolean resd;
	

	@BeforeMethod
	public void Setup() throws Exception {
		initialization();
		Lp = new Login();
		Hp = new HomePage();
		logger.info("Delete User Initialization Setup is Complete!!!");
	}

	@Test(priority = 9)
	public void DeleteUser() throws Exception {
		logger.info("Delete User Test Started!!!");
		try {
			Lp.Login_page();
			Hp.adminclick();
			Hp.usersmanclick();
			Hp.usersmenu();
			MDB = new MySqlDataBase();
			stmt = MDB.DBConnect();
			Query = "SELECT * FROM user";
			res = stmt.executeQuery(Query);
			logger.info("DataBase Connection Established!!!");
			while (res.next()) {
			String uname=res.getString("Username");
			String urole=res.getString("UserRole");
			String Ename=res.getString("EmployeeName"); 
			String sts =res.getString("Status");
				boolean Ufound = Hp.deleteuser(uname,urole,Ename,sts);
				if(Ufound){
				System.out.println("User Found: "+ uname);
				MDBD = new MySqlDataBase();
				stmtd = MDBD.DBConnect();
				DQuery = "DELETE FROM user WHERE Username="+"'"+uname+"'";
				resd = stmtd.execute(DQuery);
				}		
		} 
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Delete User Test Completed!!!");
	}

	@AfterMethod
	public void Teardown() throws SQLException {
		driver.close();// close the driver
	//	DQuery = "DELETE FROM user";
//		resd = stmt.execute(DQuery);
		MDB.DBClose();
		MDBD.DBClose();
		logger.info("Delete User Closing the DataBase Connection");
	}
}
