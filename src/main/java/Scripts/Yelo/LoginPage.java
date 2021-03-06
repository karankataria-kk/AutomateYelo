package Scripts.Yelo;

import org.openqa.selenium.By;

import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;
import Synchronisation.Synchronise;

public class LoginPage extends PageObject{
	static int retryCount = 0;
	protected static boolean launchHomePage(String homePageURL) {
		if(driver.getCurrentUrl().contains(homePageURL)) {
			retryCount = 0 ;
			return true;
		}
		else if(retryCount++ < 3) {
			Log.error("Not able to launch home page ---- Retrying - (" + retryCount + "/3)");
			driver.get(homePageURL);
			launchHomePage(homePageURL);
		}
		Log.error("Not able to launch home page.Please check with connection and configurations");
		return false;
	}
	protected static void addCredentials(String userID, String password) {
		try {
			driver.findElement(By.xpath(UILocators.LoginPage.userName_xpath)).sendKeys(userID);
			Log.info("Enering User Name --> " + userID);
			driver.findElement(By.xpath(UILocators.LoginPage.password_xpath)).sendKeys(password);
			Log.info("Enering Password --> ********");
		}catch(Exception inputError) {
			Log.error("Unable to Enter Credentials ---- Please try again");
		}
	}
	protected static void loginingIn() {
		try {
			driver.findElement(By.xpath(UILocators.LoginPage.loginButton_xpath)).click();
			Log.info("Logging IN to account");
		}catch(Exception buttonNotClickable) {
			Log.fatal("Unable to Log In  --  Button not clickable");
		}
	}
	protected static boolean validateLogin() {
		Synchronise.delay(pageLoadTime);
		if(driver.getPageSource().contains("Please enter a valid input") || driver.getPageSource().contains("This field is required")) {
			Log.error("Please Enter correct credentials in the CONFIG file");
			return false;
		}else {
			try {
				driver.findElement(By.xpath(UILocators.HomePage.notificationBarLoginChck_xpath));
				Log.info("Login Successfull");
				return true;
			}catch(Exception ElementNotFound) {
				Log.error("Unable to login  --  Please check with cresentials you entered in Config file");
				return false;
			}
		}
	}
	protected static boolean logOut() {
		try {
			driver.findElement(By.xpath(UILocators.HomePage.logOutButton_xpath)).click();
			Log.info("Trying to log out of session");
			return true;
		}catch(Exception unableToLogOut){
			if(retryCount < 3) {
				Log.error("Unable to log out -- Retrying again  - (" + retryCount + "/3) ");
				logOut();
			}
			Log.error("Unable to log out. Please check with configurations");
		}
		return false;
	}
}