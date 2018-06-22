package orange.OrangeHRM.Pages;

import orange.OrangeHRM.TestBase.TestBase;
import orange.OrangeHRM.Util.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Leave extends TestBase {

	@FindBy(xpath = ".//*[@id='menu_leave_viewLeaveModule']/b")
	WebElement leave;
	@FindBy(xpath = ".//*[@id='menu_leave_viewLeaveList']")
	WebElement viewLeavelist;
	@FindBy(xpath = ".//*[@name='leaveList[calFromDate]']//following::img[1]")
	WebElement fromdate;
	@FindBy(xpath = ".//*[@name='leaveList[calFromDate]']//following::img[2]")
	WebElement todate;
	@FindBy(xpath = ".//*[@id='leaveList_chkSearchFilter_clickboxgroup_allclick']")
	WebElement allclick;
	@FindBy(xpath = ".//*[@id='leaveList_chkSearchFilter_-1']")
	WebElement regclick;
	@FindBy(xpath = ".//*[@id='leaveList_chkSearchFilter_0']")
	WebElement canclick;
	@FindBy(xpath = ".//*[@id='leaveList_chkSearchFilter_1']")
	WebElement penappclick;
	@FindBy(xpath = ".//*[@id='leaveList_chkSearchFilter_2']")
	WebElement Schedclick;
	@FindBy(xpath = ".//*[@id='leaveList_chkSearchFilter_3']")
	WebElement Takenclick;
	@FindBy(xpath = ".//*[@id='leaveList_txtEmployee_empName']")
	WebElement Empname;
	@FindBy(xpath = ".//*[@id='leaveList_cmbSubunit']")
	WebElement subunit;
	@FindBy(xpath = "//label[@for='leaveList_cmbWithTerminated']//following::input[1]")
	WebElement pastclick;
	@FindBy(xpath = ".//*[@id='btnSearch']")
	WebElement search;
	@FindBy(xpath = ".//*[@id='btnReset']")
	WebElement reset;

	Utility ut = new Utility();
	WebDriverWait wait = new WebDriverWait (driver,20);


	// Assign the elements to the driver
	public Leave() {
		PageFactory.initElements(driver, this);
	}

	public void leaveclick() {
		ut.click(leave);
	}

	public void viewLeavelistclick() {
		ut.click(viewLeavelist);
	}

	public void fromdateclick(String date) {
	//	fromdate.clear();
		//driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[1]/a")).click();
		try {
			fromdate.sendKeys(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void todateclick(String date) {
	//	todate.clear();
	//	driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[6]/td[2]/a")).click();
		try {
			todate.sendKeys(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void allclick() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='calToDate']//following::input[1]"))).click();
	    //driver.findElement(By.xpath(".//*[@id='calToDate']//following::input[1]")).click();
		//ut.click(allclick);
	}

	public void regclick() {
		ut.click(regclick);
	}

	public void canclick() {
		ut.click(canclick);
	}

	public void penappclick() {
		ut.click(penappclick);
	}

	public void Schedclick() {
		ut.click(Schedclick);
	}

	public void Takenclick() {
		ut.click(Takenclick);
	}

	public void Empname(String name) {
		try {
			Empname.clear();
			Empname.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void subunit() {
		ut.selectDrpdwn(subunit, "All");
	}

	public void pastclick() {
		ut.click(pastclick);
	}

	public void search() {
		ut.click(search);
	}

	public void reset() {
		ut.click(reset);
	}
}
