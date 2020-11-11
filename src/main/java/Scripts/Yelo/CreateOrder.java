package Scripts.Yelo;

import org.openqa.selenium.By;

import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;
import Synchronisation.Synchronise;

public class CreateOrder extends PageObject{
	protected static void navigateToOrders() {
		try {
			driver.findElement(By.xpath(UILocators.LeftPane.ordersButton_xpath)).click();
			Log.info("Click on Orders Button in left pane");
		}catch(Exception ordersTabNotFound) {
			Log.error("Unable to navigate to orders tab, There may be an network connection error <<Slow network connection>>");
		}
	}
	protected static boolean createOrderProcess() {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.createOrderButton_xpath)).click();
			Log.info("Click on create order button");
			return true;
		}catch(Exception buttonNotFound) {
			Log.error("Unable to find create order button");
			return false;
		}
	}
	protected static void addNewCustomer(String name, String email,String password, String phone) {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.addNewCustomerButton)).click();
			Log.info("Click on add new customer button");
			Synchronise.delay(pageLoadTime);
			enterNewCustomerDetails(name,email,password,phone);
			Synchronise.delay(pageLoadTime);
		}catch(Exception buttonNotFound) {
			Log.error("Unable to add new customer  --  Please check with UI Locators");
		}
		customerAlreadyExists();
	}
	private static void customerAlreadyExists() {
		Synchronise.delay(pageLoadTime);
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.continueButtonAlreadyExists_xpath)).click();
			Log.error("Customer already found, moving forward with the same customer");
		}catch(Exception customerNotFound){
			Log.info("Registering new Customer");
		}
	}
	private static void enterNewCustomerDetails(String name, String email,String password, String phone) {
		try {
			Log.info("Creating new user with name - ");
			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerName_xpath)).sendKeys(name);
			Log.info("Entering name - " + name);
			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerEmail_xpath)).sendKeys(email);
			Log.info("Entering email id - " + email);
			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerPassword_xpath)).sendKeys(password);
			Log.info("Entering passsword - **********");
			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerPhone_xpath)).sendKeys(phone);
			Log.info("Entering phone number - " + phone);
			driver.findElement(By.xpath(UILocators.OrdersPage.addNewCustomerButton)).click();
			Log.info("Click on Add Button");
		}catch(Exception formNotAvailable) {
			Log.error("Unable to add new customer");
		}
	}
	protected static void selectDeliveryMethod(String deliveryMethod) {
		try {
			if(deliveryMethod.equalsIgnoreCase("take away"))
				driver.findElement(By.xpath(UILocators.OrdersPage.takeAwayDeliveryMethod_xpath)).click();
			else if(deliveryMethod.equalsIgnoreCase("pick and drop"))
				driver.findElement(By.xpath(UILocators.OrdersPage.pickAndDropDeliveryMethod_xpath)).click();
			else {
				driver.findElement(By.xpath(UILocators.OrdersPage.homeDeliveryMethod_xpath)).click();
				deliveryMethod = "Home Delivery";
			}
			Log.info("Selecting delivery method as -" + deliveryMethod);
		}catch(Exception unableToSetDeliveryMethod) {
			Log.error("Unable to set delivery method");
		}
	}
	protected static void selectMerchant(String merchant) {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.selectMerchant_xpath)).sendKeys(merchant);
			Log.info("Entering merchant name - " + merchant);
		}catch(Exception unableToAddMerchant) {
			Log.error("Unable to add merchant");
		}
	}
	protected static void enterProductName(String product) {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.enterProducts_xpath)).sendKeys(product);
			Log.info("Adding product - " + product + "to the list");
		}catch(Exception ElementNotFound) {
			Log.error("unable to add products");
		}
	}
	protected static void enterSuggestions(String suggestions) {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.addSuggestions_xpath)).sendKeys(suggestions);
			Log.info("Adding suggestions - " + suggestions);
		}catch(Exception suggestionNotAdded) {
			Log.error("unable to add suggestions");
		}
	}
	protected static void checkInvoice() {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.invoiceButton_xpath)).click();
			Log.info("Checking invoice creation");
		}catch(Exception noInvoiceButton) {
			Log.error("Unable to find Invoice button");
		}
	}
	protected static boolean createOrder() {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.createOrderFinalButton_xpath)).click();
			Log.info("Click on create order");
			return true;
		}catch(Exception ex) {
			Log.error("Unable to create order");
			return false;
		}
	}
	protected static boolean validateCreatedOrder() {
		int findPopUpCount = 0;
		if(driver.getPageSource().contains("This field is required.")) {
			return false;
		}
		while(findPopUpCount < 10) {
			try {
				driver.findElement(By.xpath(UILocators.OrdersPage.orderSucessfullPopUp_xpath));
				Log.info("Order successfull - Validated");
				return true;
			}catch(Exception popUpNotFound) {
				Synchronise.delay(pageLoadTime/5);
				if(findPopUpCount == 9) {
					Log.error("Unable to see order succesfull validation pop-up");
					return false;
				}
			}
		}
		return false;
	}
}