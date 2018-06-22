package orangeHRM.TestCases;

import java.sql.Statement;

import orange.OrangeHRM.TestBase.TestBase;
import orange.OrangeHRM.TestData.MySqlDataBase;

import org.testng.annotations.Test;

public class TC2_Home_PageTest_CreateData extends TestBase {

	MySqlDataBase MDB;
	
	@Test(priority=2)
	public void HomePage_CreateTest() throws Exception {
		logger.info("Create Data module Started!!!");
		MDB = new MySqlDataBase();
		String Query;
		Statement stmt = MDB.DBConnect();
		for(int i=0;i<4;i++){
		try {
			String Uname = "Rock"+i;
			if(i%2==0){
			Query = "INSERT INTO user(UserRole,EmployeeName,Username,Status,Password,CPassword) "
					+ "values('Admin','John Smith','"
					+Uname
					+"','Enabled','"
					+Uname
					+"','"
					+Uname
					+"')";
			}
			else
			{
				 Query = "INSERT INTO user(UserRole,EmployeeName,Username,Status,Password,CPassword) "
						+ "values('ESS','John Smith','"
						+Uname
						+"','Enabled','"
						+Uname
						+"','"
						+Uname
						+"')";
			}
			stmt.execute(Query); // Execute or executeUpdate Statement should be used for DML Statements
		logger.info("Data Inserted :"+Uname);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Data cannot be Created!!!");
		}
		}
		
		MDB.DBClose();
		logger.info("Closing Data Creation module!!!");
	}
}
