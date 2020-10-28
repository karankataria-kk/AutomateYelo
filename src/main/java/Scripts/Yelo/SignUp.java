package Scripts.Yelo;

import org.openqa.selenium.By;

import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;
import Synchronisation.Synchronise;

public class SignUp extends PageObject{
	protected static void navigateToSignUpPage() {
		try {
			driver.findElement(By.linkText("Sign Up")).click();
			Log.info("Navigating to Sign Up Page");
		}catch(Exception signUpOptionNotFound) {
			Log.error("Unable to navigate to sign up page");
		}
	}
	static void enterName(String name) {
		try {
			driver.findElement(By.xpath(UILocators.SignUpPage.nameInput_xpath)).sendKeys(name);
			Log.info("Entering name - " + name);
		}catch(Exception unableToEnterName) {
			Log.error("Unable to enter name");
		}
	}
	static void enterEmailId(String emailId) {
		try {
			driver.findElement(By.xpath(UILocators.SignUpPage.emailInput_xpath)).sendKeys(emailId);
			Log.info("Entering email id - " + emailId);
		}catch(Exception unableToEnterEmailId) {
			Log.error("Unable to enter email id");
		}
	}
	static void enterPassword(String password) {
		try {
			driver.findElement(By.xpath(UILocators.SignUpPage.passwordInput_xpath)).sendKeys(password);
			Log.info("Entering password - **********");
		}catch(Exception unableToEnterPassword) {
			Log.error("Unable to enter password");
		}
	}
	static void enterContact(String contact) {
		try {
			driver.findElement(By.xpath(UILocators.SignUpPage.contactNumberInput_xpath)).sendKeys(contact);
			Log.info("Entering Contact Number - " + contact);
		}catch(Exception unableToEnterNumber) {
			Log.error("Unable to enter contact number");
		}
	}
	static boolean continueButton() {
		try {
			driver.findElement(By.xpath(UILocators.SignUpPage.continueButton_xpath)).click();
			Log.info("Click on continue button");
		}catch(Exception unableToContinue) {
			Log.error("Unable to Continue");
			return false;
		}
		return true;
	}
	static boolean validateSignUp() {
		Synchronise.delay(pageLoadTime);
		if(driver.getCurrentUrl().contains("step1") || driver.getPageSource().contains("You are already registered on JungleWorks. Please login with same credentials.")) {
			Log.error("Already registered using this Information.... The web page says :-");
			Log.error("You are already registered on JungleWorks. Please login with same credentials.");
			return false;
		}
		return true;
	}
	protected static boolean enterDetails(String name , String emailId, String password, String contactNumber) {
		//Synchronise.isClicakble("xpath", UILocators.SignUpPage.nameInput_xpath);
		Log.info("***** STEP - 1 *****");
		Synchronise.delay(pageLoadTime);
		enterName(name);
		enterEmailId(emailId);
		enterPassword(password);
		enterContact(contactNumber);
		if(continueButton())
			return validateSignUp();
		return false;
	}
	static protected boolean enterBuisenessName(String buisnessName) {
		try {
			driver.findElement(By.xpath(UILocators.SignUpPage.buisnessNameInput_xpath)).sendKeys(buisnessName);
			Log.info("Entering Buisness name - " + buisnessName);
		}catch(Exception unableToEnterName) {
			Log.error("Unable to enter buisness name");
		}
		try {
			Synchronise.delay(pageLoadTime/2);
			driver.findElement(By.xpath(UILocators.SignUpPage.nextButton_xpath)).click();
		}catch(Exception unableToContinue){
			Log.error("Not able to continue with this buisness name");
			if(driver.getPageSource().contains("Store name not available"))
				Log.fatal("Web page says - Store name not available");
			return false;
		}
		return true;
	}
	protected static void chooseBuisnessIdea(String idea) {
		try {
			Synchronise.delay(pageLoadTime/2);
			driver.findElement(By.xpath(UILocators.SignUpPage.UILocatorBuisnessIdea_part1 + idea + UILocators.SignUpPage.UILocatorBuisnessIdea_part2)).click();
			Log.info("Selecting buisness category/idea - " + idea);
		}catch(Exception buisnessIdeaNotFound) {
			Log.error("Not able to find your buisness idea in the list");
			driver.findElement(By.xpath(UILocators.SignUpPage.UILocatorBuisnessIdeaOthers_xpath)).click();
			Log.info("Listing your buisness in general category - others");
		}
		try {
			driver.findElement(By.xpath(UILocators.SignUpPage.nextButton_xpath)).click();
		}catch(Exception notAbleTOProceed) {
			Log.error("Please check with the details provided... Not able to proceed further");
		}
	}	
}