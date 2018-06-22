package orange.OrangeHRM.Util;

import orange.OrangeHRM.TestBase.TestBase;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
public class Utility extends TestBase {
// Global Time Out Variables
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	String parentWindow;
	Date date = new Date();

// Reusable Utilities
	
	

// Accept the Alert on a Page
	public static void acceptAlert() {
		try {
			Thread.sleep(2000);
			wait = new WebDriverWait(driver, 10);
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("No alert");
			} else {
				driver.switchTo().alert().accept();
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("No Alert present");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

// Cancel the Alert on a Page
	public static void cancelAlert() {
		try {
			Thread.sleep(2000);
			wait = new WebDriverWait(driver, 10);
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("No alert");
			} else {
				driver.switchTo().alert().dismiss();
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("No Alert present");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

// return the Alert Text on a Page
	public static String getAlertText() {
		String result = null;
		try {
			Thread.sleep(2000);
			wait = new WebDriverWait(driver, 10);
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("No alert");
			} else {
				result = driver.switchTo().alert().getText();
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("No Alert present");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
//Selecting the DropDown Element by Visible Text, Index,by Value	
//Overloading - Polymorphism
	
	public void selectDrpdwn(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectDrpdwn(WebElement element, int index) {
		try {
			Select select  = new Select(element);
			select.selectByIndex(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectDrpdwnByValue(WebElement element, String value) {
		Select select  = new Select(element);
		select.selectByValue(value);
	}
	
//Method to Switch to another Window	
	public void switchToWindow() {
		parentWindow = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			String childwindow = it.next().toString();
			if (!childwindow.contains(parentWindow)) {
				driver.switchTo().window(childwindow);
			}
		}
	}
//Method to Switch back to the Main window
	public void switchToMainWindow() {
		driver.switchTo().window(parentWindow);
	}
	public void click(WebElement chk) {
		try {
			chk.click();
		} catch (Exception e) {
			System.out.println("Unable to Click");
			e.printStackTrace();
		}
	}
	
	public void check(WebElement ck){
		try {
			ck.click();
		} catch (Exception e) {
			System.out.println("Unable to Check");
			e.printStackTrace();
		}
	}
}
