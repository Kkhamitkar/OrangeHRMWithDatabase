package orange.OrangeHRM.Pages;

import orange.OrangeHRM.TestBase.TestBase;
import orange.OrangeHRM.Util.Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Recruitment extends TestBase {
	//Declare Global Variables
	Utility utl = new Utility();

	//Vacancy WebElements
	@FindBy(xpath=".//*[@id='vacancySearch_jobTitle']")
	WebElement Jtitle;
	
	@FindBy(xpath=".//*[@id='vacancySearch_jobVacancy']")
	WebElement Vac;
	
	@FindBy(xpath=".//*[@id='vacancySearch_hiringManager']")
	WebElement Hm;
	
	@FindBy(xpath=".//*[@id='vacancySearch_status']")
	WebElement Sts;
	
	@FindBy(xpath=".//*[@id='btnSrch']")
	WebElement Search;
	
	@FindBy(xpath=".//*[@id='btnRst']")
	WebElement Reset;
	
	
	
	public void Candiates(){
		
	}
	
	public void Vacancy(){
		
		
	}
	
}
