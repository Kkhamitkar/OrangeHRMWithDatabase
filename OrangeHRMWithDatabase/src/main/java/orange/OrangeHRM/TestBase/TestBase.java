package orange.OrangeHRM.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import orange.OrangeHRM.Util.Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	//Declare the variables globally
	public static WebDriver driver;
	public static Properties Prop;
	public static WebDriverWait wait;
	
	//Extent Reporting declaration
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger logger =Logger.getLogger("ExtentReportTestBase");
	
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/Test" + formater.format(calendar.getTime()) + ".html", false);
		PropertyConfigurator.configure("Log4j.properties");
 }
	
	
	// Base Class Constructor
	public TestBase() {
		
		try {
			
			Prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")
							+ "/src/main/java/orange/OrangeHRM/Config/Config.properties");
			Prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Initialize the browser
	public void initialization(){
		String BrowserName = Prop.getProperty("browser");
		//Setup the property for the browser
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/SeleniumNew/browsers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(BrowserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:/SeleniumNew/browsers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(BrowserName.equals("InternetExplorer")){
			System.setProperty("webdriver.ie.driver","C:/SeleniumNew/browsers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(BrowserName.equals("Edge")){
			System.setProperty("webdriver.edge.driver","C:/SeleniumNew/browsers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
//		else if(BrowserName.equals("HtmlUnitDriver")){
//			driver = new HtmlUnitDriver();
//		}
//		//set up the default values
		
		driver.manage().window().maximize(); //Maximize the Window
		driver.manage().deleteAllCookies();  //Delete all the existing Cookies
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //Allow extra time to load the page
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS); //Allow wait each actions on the page
		driver.get(Prop.getProperty("url"));
		
	}
	
	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}
	//Creating a method getScreenshot and passing two parameters 
	//driver and screenshotName
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	                //below line is just to append the date format with the screenshot name to avoid duplicate names		
	                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
	                
			//Returns the captured file path
			return destination;
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		extent.loadConfig(new File("./extent-config.xml"));
	}
	
	@AfterMethod()
	public void afterMethod(ITestResult result) {
		getresult(result);
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		extent.endTest(test);
		extent.flush();
	}
}
