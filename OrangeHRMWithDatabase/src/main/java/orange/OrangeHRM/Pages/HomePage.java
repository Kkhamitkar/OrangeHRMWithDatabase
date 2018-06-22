package orange.OrangeHRM.Pages;

import static org.testng.Assert.assertEquals;
import orange.OrangeHRM.TestBase.TestBase;
import orange.OrangeHRM.Util.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
	// Identify all the Web elements and global variables
	@FindBy(xpath = ".//li[@class='current']/a/b")
	WebElement dashboard;
	
	@FindBy(xpath=".//*[@id='menu_admin_viewAdminModule']/b")
	WebElement admin;
	@FindBy(xpath=".//*[@id='menu_admin_UserManagement']")
	WebElement usermag;
	@FindBy(xpath = ".//*[@id='menu_admin_viewSystemUsers']")
	WebElement users;
	@FindBy(xpath = ".//*[@id='btnAdd']")
	WebElement Add;
	@FindBy(xpath=".//*[@id='systemUser_userName']//following::span")
	WebElement Useralreadyexist;
	@FindBy(xpath=".//*[@id='btnDelete']")
	WebElement Delete;
	@FindBy(xpath=".//*[@id='dialogDeleteBtn']")
	WebElement OkDelete;
	@FindBy(xpath=".//*[@id='dialogDeleteBtn']//following::input")
	WebElement CancelDelete;
	@FindBy(xpath=".//*[@id='systemUser_userType']")
	WebElement userrole;
	@FindBy(xpath=".//*[@id='systemUser_employeeName_empName']")
	WebElement empname;
	@FindBy(xpath=".//*[@id='systemUser_userName']")
	WebElement username;
	@FindBy(xpath=".//*[@id='systemUser_status']")
	WebElement status;
	@FindBy(xpath=".//*[@id='systemUser_password']")
	WebElement password;
	@FindBy(xpath=".//*[@id='systemUser_confirmPassword']")
	WebElement cpassword;
	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement Save;
	@FindBy(xpath=".//*[@id='btnCancel']")
	WebElement Cancel;
	Utility utl = new Utility();
	
	//Recruitment
	
	@FindBy(xpath=".//a[@id='menu_recruitment_viewRecruitmentModule']")
	WebElement recruitment;
	@FindBy(xpath=".//*[@id='menu_recruitment_viewCandidates']")
	WebElement Vcand;
	@FindBy(xpath=".//*[@id='menu_recruitment_viewJobVacancy']")
	WebElement VJVac;
	
	//Search Username
	@FindBy(xpath=".//input[@id='searchSystemUser_userName']")
	WebElement searchusername;
	@FindBy(xpath=".//select[@id='searchSystemUser_userType']")
	WebElement searchrole;
	@FindBy(xpath=".//input[@id='searchSystemUser_employeeName_empName']")
	WebElement searchempname;
	@FindBy(xpath=".//select[@id='searchSystemUser_status']")
	WebElement searchstatus;
	@FindBy(xpath=".//input[@id='searchBtn']")
	WebElement searchButton;
	@FindBy(xpath=".//input[@id='resetBtn']")
	WebElement resetButton;
	@FindBy(xpath=".//*[@id='tableWrapper']//following::td")
	WebElement searchresult;
	
	

	// Assign all the web Elements to the local web elements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Perform the Actions
//ADMIN Module	
	//Start of Default Menu
	public String defaultmenu() {
		String result = null;
		try {
			result = dashboard.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}// End of DefaultMenu Method
	
//	Start of Usersmenu click
	public void usersmenu(){
		try {
			users.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //End of Usersmenu Click	
	
//	Start of Admin click
	public void adminclick(){
		try {
			admin.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //End of Admin Click	

//	Start of usermanagement click click
	public void usersmanclick(){
		try {
			usermag.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //End of Usersman Click	
//	Start of Add Click 
	public void Addclick(){
		try {
			Add.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//End of Add Click
	
// Start of Delete Click
	public void DeleteClick(){
		try{
			Delete.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Start of Delete Click
		public void OkDeleteClick(){
			try{
				OkDelete.click();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		// Start of Delete Click
		public void CancelDeleteClick(){
			try{
				CancelDelete.click();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	//Recruit page
		public void Recruitment()throws Exception{
		utl.click(recruitment);
		}
		
		
//Add New Users Admin and Employees
	public void AddUser(String role,String ename,String uname,String stat,String pass,String cpass) {
		
			Addclick();
			utl.selectDrpdwn(userrole, role);
			empname.clear();
			empname.sendKeys(ename);
			username.clear();
			username.sendKeys(uname);
			utl.selectDrpdwn(status, stat);
			password.clear();
			password.sendKeys(pass);
			cpassword.clear();
			cpassword.sendKeys(cpass);
			Save.click();
	}
	
	public void searchuser(String uname,String role,String ename,String status){
		searchusername.clear();
		searchusername.sendKeys(uname);
		utl.selectDrpdwn(searchrole, role);
		searchempname.clear();
		searchempname.sendKeys(ename);
		utl.selectDrpdwn(searchstatus,status);
		searchButton.click();
		String result = searchresult.getText(); 	
		
		if(!result.equals("No Records Found")){
			
			assertEquals(uname,driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td[2]")).getText());
			assertEquals(role,driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td[3]")).getText());
			assertEquals(ename,driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td[4]")).getText());
			assertEquals(status,driver.findElement(By.xpath("	//*[@id='resultTable']/tbody/tr/td[5]")).getText());
			System.out.println("Record Found for:"+uname);
		}
		else 
			System.out.println("No Records Found for:"+uname);
	}
	
	public boolean deleteuser(String uname,String role,String ename,String status) throws InterruptedException{
		boolean Userfound=false;
		searchusername.clear();
		searchusername.sendKeys(uname);
		utl.selectDrpdwn(searchrole, role);
		searchempname.clear();
		searchempname.sendKeys(ename);
		utl.selectDrpdwn(searchstatus,status);
		searchButton.click();
		String result = driver.findElement(By.xpath(".//*[@id='tableWrapper']//following::td")).getText(); 	
		System.out.println(result);
		
		if(!result.equals("No Records Found"))
		{
	String Suname =	driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr[1]/td[2]")).getText();
	if(Suname.equals(uname)){
		driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr[1]/td[2]//preceding::td")).click();
		DeleteClick();
		OkDelete.click();
		System.out.println(uname+"/"+ename+"has been Deleted from the System!!");
		Userfound=true;
	}
	}
		else
			System.out.println(uname+"/"+ename+" NOT FOUND!!! " );
		return Userfound;
	
	} //Delete User

}// End of Main class
