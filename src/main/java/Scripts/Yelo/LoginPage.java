package Scripts.Yelo;

import org.openqa.selenium.By;

import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;

public class LoginPage extends PageObject{
	static int retryCount = 0;
	public static boolean launchHomePage(String homePageURL) {
		if(driver.getCurrentUrl().contains(homePageURL))
			return true;
		else if(retryCount++ < 3) {
			Log.error("Not able to launch home page ---- Retrying - (" + retryCount + "/3)");
			driver.get(homePageURL);
			launchHomePage(homePageURL);
		}
		Log.error("Not able to launch home page.Please check with connection and configurations");
		return false;
	}
	public static void addCredentials(String userID, String password) {
		try {
		driver.findElement(By.xpath(UILocators.LoginPage.userName_xpath)).sendKeys(userID);
		Log.info("Enering User Name --> " + userID);
		driver.findElement(By.xpath(UILocators.LoginPage.password_xpath)).sendKeys(password);
		Log.info("Enering Password --> ********");
		}catch(Exception inputError) {
			Log.error("Unable to Enter Credentials ---- Please try again");
		}
	}
	public static void loginingIn() {
		try {
		driver.findElement(By.xpath(UILocators.LoginPage.loginButton_xpath)).click();
		Log.info("Logging IN to account");
		}catch(Exception buttonNotClickable) {
			Log.fatal("Unable to Log In  --  Button not clickable");
		}
	}
	public static boolean validateLogin() {
		if(driver.getPageSource().contains("Please enter a valid input") || driver.getPageSource().contains("This field is required")) {
			Log.error("Please Enter correct credentials in the CONFIG file");
			return false;
		}
		Log.info("Login Successfull");
		return true;
	}
}
