package orangeHRM.TestCases;

import static org.testng.Assert.assertEquals;
import orange.OrangeHRM.Pages.Login;
import orange.OrangeHRM.TestBase.TestBase;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC1_Login_PageTest extends TestBase {
	// Declare Global variables and classes
	Login Lp;

	@BeforeMethod
	public void SetUp() {
		initialization();
		Lp = new Login();
		logger.info("LoginPage Initialization Complete!!!");
	}

	@Test(priority=1)
	public void Login_validLogin() throws InterruptedException {
		logger.info("ValidLogin Test Started!!");
		if (Lp.Login_page()){
			String Actresult = driver.findElement(By.xpath(".//*[@id='welcome']")).getText();
			String Expresult = "Welcome Admin";
		assertEquals(Actresult, Expresult);	
		}
		else
			System.out.println("Not Logged In");
		logger.info("ValidLogin Test Completed!!");
	}
	@AfterMethod
	public void Teardown() {
		driver.close();
	}

}
