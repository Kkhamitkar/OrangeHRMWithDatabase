package orangeHRM.TestCases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import orange.OrangeHRM.Pages.HomePage;
import orange.OrangeHRM.Pages.Login;
import orange.OrangeHRM.TestBase.TestBase;
import orange.OrangeHRM.TestData.MySqlDataBase;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC3_Home_PageTest extends TestBase {
	Login Lp;
	HomePage Hp;
	MySqlDataBase MDB;
	
	@BeforeMethod
	public void Setup() {
		initialization();
		Lp = new Login();
		Hp = new HomePage();
		logger.info("Home Page Test Setup Complete!!!");
	}

	@Test(priority=3)
	public void HomePage_AdduserTest() throws Exception {
		logger.info("Home Page Add user Method Started!!!");
		Lp.Login_page();
		Hp.adminclick();
		Hp.usersmanclick();
		Hp.usersmenu();
		MDB = new MySqlDataBase();
		
		logger.info("Home Page Data Connection Started!!");
			
				String Query = "SELECT * FROM user";
				Statement stmt = MDB.DBConnect();
				ResultSet res = stmt.executeQuery(Query);
				//Add all the Records from the Table
				while(res.next()){
					
				try {
					Hp.AddUser(
							res.getString("UserRole"),
							res.getString("EmployeeName"),
							res.getString("Username"),
							res.getString("Status"),
							res.getString("Password"),
							res.getString("CPassword"));
					try {
						driver.findElement(By.xpath(".//*[@id='systemUser_status']//preceding::span")).isDisplayed();
						 System.out.println("Already Exists:" +res.getString("EmployeeName"));
						driver.findElement(By.xpath(".//*[@id='btnCancel']")).click();	
					} catch (Exception e) {
						System.out.println("Inserted into Application : "+res.getString("EmployeeName")+"/"+res.getString("UserRole"));
						Statement stmta = MDB.DBConnect();
						String Iquery ="INSERT INTO Result (UserRole,EmployeeName,Username,Status,Password,CPassword) VALUES "
							+"('"+res.getString("UserRole")+"',"
							+"'"+res.getString("EmployeeName")+"',"
							+"'"+res.getString("Username")+"',"
							+"'"+res.getString("Status")+"',"
							+"'"+res.getString("Password")+"',"
							+"'"+res.getString("CPassword")+"')";
						stmta.execute(Iquery);
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//continue;
					e.printStackTrace();
				}
				}
			
			MDB.DBClose();
			logger.info("Home Page Data connection Closed!!!");
		}
	
	@Test(priority=4)
	public void HomePage_SearchuserTest() throws Exception{
		logger.info("Home Page Search User Started!!!");
		Lp.Login_page();
		Hp.adminclick();
		Hp.usersmanclick();
		Hp.usersmenu();
		MDB = new MySqlDataBase();
				
		try {
			logger.info("Home Page User Search DataBase Connection Started!!!");
			//	String insertQuery = ""
			logger.info("Query assigned");
				String Query = "SELECT * FROM user";
				logger.info("DB Connection");
				Statement stmt = MDB.DBConnect();
				logger.info("Execute the Query");
				ResultSet res = stmt.executeQuery(Query);
				//Add all the Records from the Table
				logger.info("Traverse the Data");
				while(res.next()){
				Hp.searchuser(
						res.getString("Username"),
						res.getString("UserRole"),
						res.getString("EmployeeName"),
						res.getString("Status"));
				}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("HomePage Search User Exception");
		}
}

	@AfterMethod
	public void Teardown() throws SQLException {
		driver.close();
		MDB.DBClose();
		logger.info("Closing the Home Page Method");
			}

}
