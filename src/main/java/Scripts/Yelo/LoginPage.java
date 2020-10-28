package Scripts.Yelo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Configuration.Config;
import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;
public class LoginPage extends PageObject{
	public static boolean launchHomePage(String homePageURL) {
		if(driver.getCurrentUrl().contains(homePageURL))
			return true;
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
