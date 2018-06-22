package orange.OrangeHRM.Pages;

import orange.OrangeHRM.TestBase.TestBase;
import orange.OrangeHRM.Util.Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends TestBase {
//Find the Web elements and assign
	@FindBy(xpath=".//*[@id='menu_dashboard_index']/b")
	WebElement dashmenu;
	@FindBy(xpath=".//*[@class='quickLinkText' and text()='Assign Leave']")
	WebElement assignleave;
	@FindBy(xpath=".//*[@class='quickLinkText' and text()='Leave List']")
	WebElement leavelist;
	@FindBy(xpath=".//*[@class='quickLinkText' and text()='Timesheets']")
	WebElement timesheets;
	Utility utl = new Utility();
	
	//Assign the WebElements to this driver
	public Dashboard(){
		PageFactory.initElements(driver, this);
	}
	
	public void dashmenu(){
		utl.click(dashmenu);
	}
	public void Assignleave(){
		utl.click(assignleave);
	}
	public void Leavelist(){
		utl.click(leavelist);
	}
	public void timesheets(){
		utl.click(timesheets);
	}
	
	
	
	
}
