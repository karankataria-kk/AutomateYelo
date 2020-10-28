package Scripts.Yelo;

import org.openqa.selenium.By;

import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;

public class SignUp extends PageObject{
	protected static void navigateToSignUpPage() {
		try {
			driver.findElement(By.linkText("Sign Up")).click();
			Log.info("Navigating to Sign Up Page");
		}catch(Exception signUpOptionNotFound) {
			Log.error("Unable to navigate to sign up page");
		}
	}
	protected static void enterDetails(String name) {
		driver.findElement(By.xpath(UILocators.SignUpPage.nameInput_xpath)).sendKeys(name);
		Log.info("Entering name - " + name);
	}
}