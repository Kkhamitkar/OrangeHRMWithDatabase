package orangeHRM.TestCases;

import static org.testng.Assert.assertEquals;
import orange.OrangeHRM.Pages.Dashboard;
import orange.OrangeHRM.Pages.Login;
import orange.OrangeHRM.TestBase.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC4_Dashboard_PageTest extends TestBase {
	
	Dashboard Db;
	Login Lop;

	@BeforeMethod
	public void Setup(){
		initialization();
		Lop = new Login();
		Db = new Dashboard();
		logger.info("DashBoard page initialization Completed!!!");
			}
	
	@Test(priority=5)
	public void Dashboard_AssignLeaveTest() {
		logger.info("Dashboard AssignLeave Test Started!!!");
		Lop.Login_page();
		Db.Assignleave();
		WebElement assignbutton = driver.findElement(By.xpath(".//*[@id='assignBtn']"));
		Assert.assertEquals(true, assignbutton.isDisplayed());
		assignbutton.click();
		System.out.println("DashBoard_AssignLeaveTest Passed!!");
		logger.info("Dashboard AssignLeave Completed!!!");
		}
	
	@Test(priority=6)
	public void Dashboard_LeaveListTest(){
		logger.info("Dashboard Leave List Test Started!!!");
		Lop.Login_page();
		Db.Leavelist();
		WebElement viewlist = driver.findElement(By.xpath(".//*[@id='menu_leave_viewLeaveList']"));
		assertEquals(true, viewlist.isDisplayed());
		logger.info("Dashboard Leave List Test Completed!!!");		
	}
	
	@Test(priority=7)
	public void Dashboard_TimesheetTest(){
		logger.info("Dashboard Timesheet Test Started!!!");
		Lop.Login_page();
		Db.timesheets();;
		WebElement timsht = driver.findElement(By.xpath(".//*[@id='content']/div[2]"));
		assertEquals(true, timsht.isDisplayed());
		logger.info("Dashboard Timesheet Test Completed!!!");		
	}
	
	@AfterMethod
	public void Teardown(){
		driver.close();
	}
	
}
