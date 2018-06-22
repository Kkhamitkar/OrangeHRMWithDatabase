package orangeHRM.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import orange.OrangeHRM.Pages.Leave;
import orange.OrangeHRM.Pages.Login;
import orange.OrangeHRM.TestBase.TestBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC5_Leave_PageTest extends TestBase {
	Login Lop;
	Leave Lep;
	Robot robot;
	
	@BeforeMethod
	public void Setup() throws AWTException{
		initialization();
		Lop = new Login();
		Lep = new Leave();
		robot = new Robot();
		logger.info("Leave Page Initialization Started!!!");
	}
	//
	@Test(priority=8,groups={"SmokeTest"})
	public void LeavePage_AllTest() throws InterruptedException{
		logger.info("Leave Page AllCheckbox Test Started");
		logger.info("st:Login_page");
		Lop.Login_page();
		logger.info("end:Login_page");
		logger.info("st:leaveclick");
		Lep.leaveclick();
		logger.info("end:leaveclick");
		logger.info("st:viewleavelist");
		Lep.viewLeavelistclick();
		logger.info("end:view leavelist");
		logger.info("st:enterdate");
	//	Lep.fromdateclick("2018-01-01");
		logger.info("end date enter");
		logger.info("st: tab press");
		robot.keyPress(KeyEvent.VK_TAB);
		logger.info("end: tab press");
		logger.info("enter date");
	//	Lep.todateclick("2019-12-31");
		logger.info("end: date");
		logger.info("st: tab press");
		robot.keyPress(KeyEvent.VK_TAB);	
		logger.info("end: tab press");
		logger.info("st: all check");
		Lep.allclick();
		logger.info("end: all check");
		Lep.Empname("John Smith");
		Lep.subunit();
		Lep.pastclick();
		Lep.search();
		logger.info("Leave Page All Checkbox Test Completed");
	}
	
	@AfterMethod
	public void Teardown(){
		driver.close();
		logger.info("Leave Page All checkbox closing the Driver session");
	}
}
