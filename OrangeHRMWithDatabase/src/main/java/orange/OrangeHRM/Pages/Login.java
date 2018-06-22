package orange.OrangeHRM.Pages;

import orange.OrangeHRM.TestBase.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends TestBase {
	//Declare the Global Variables
	//Declare and assign the WebElements
	@FindBy (xpath=".//*[@id='txtUsername']")
	WebElement username;
	@FindBy(xpath=".//*[@id='txtPassword']")
	WebElement password;
	@FindBy(xpath=".//*[@id='btnLogin']")
	WebElement login;
	@FindBy(xpath=".//*[@id='divLogo']/img")
	WebElement logo;
	
	//Assign all the WebElements using PageFactory
	
	public Login(){
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Perform the Actions on the WebElements
	
	public String Login_GetTitle(){
		String title = null;
		try{
			title = driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{

			System.out.println("Finally Block");
		}
		return title;
	}
	
	public boolean Login_page(){
			boolean result =false;
			
			try {
				username.clear();
				username.sendKeys(Prop.getProperty("Username"));
				password.clear();
				password.sendKeys(Prop.getProperty("Password"));
				login.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result=true;
		return result;
	}
	
	public boolean Image(){
		boolean result =false;
		try{
			if(logo.isDisplayed())
				result=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

} //End of Page Class
