package Scripts.Yelo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Configuration.Config;
import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;
public class LoginPage extends PageObject{
	@FindBy(xpath = UILocators.LoginPage.userName_xpath)
	WebElement userIDInput;
	@FindBy(xpath = UILocators.LoginPage.password_xpath)
	WebElement passwordInput;
	@FindBy(xpath = UILocators.LoginPage.loginButton_xpath)
	WebElement loginButton;
	public static boolean launchHomePage(String homePageURL) {
		driver.get(homePageURL);
		Log.info("Navigating to Home page --> " + homePageURL);
		if(driver.getCurrentUrl().contains(homePageURL))
			return true;
		return false;
	}
	public void addCredentials(String userID, String password) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userIDInput.sendKeys(userID);
		Log.info("Enering User Name --> " + userID);
		passwordInput.sendKeys(password);
		Log.info("Enering Password --> ********");
	}
	public void loginingIn() {
		loginButton.click();
		Log.info("Logging IN to account");
	}
}
