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
			Synchronise.delay(pageLoadTime);
			driver.findElement(By.xpath(UILocators.OrdersPage.createOrderButton_xpath)).click();
			Log.info("Click on create order button");
			return true;
		}catch(Exception buttonNotFound) {
			Log.error("Unable to find create order button");
			return false;
		}
	}
	protected static void selectCustomer(String customerName) {
		try {
			Synchronise.delay(pageLoadTime);
			driver.findElement(By.xpath(UILocators.OrdersPage.selectCustomer_xpath)).sendKeys(customerName);
			Synchronise.delay(pageLoadTime/5);
			driver.findElement(By.xpath(UILocators.OrdersPage.selectCustomerDropDown_xpath1 + customerName + UILocators.OrdersPage.selectCustomerDropDown_xpath2)).click();
			Log.info("Adding customer name - " + customerName);
		}catch(Exception unableToAddCUstomer) {
			Log.error("Unable to add customer");
		}
	}
//	protected static void addNewCustomer(String name, String email,String password, String phone) {
//		try {
//			Synchronise.delay(pageLoadTime);
//			driver.findElement(By.xpath(UILocators.OrdersPage.addNewCustomerButton_xpath)).click();
//			Log.info("Click on add new customer button");
//			Synchronise.delay(pageLoadTime);
//			enterNewCustomerDetails(name,email,password,phone);
//			Synchronise.delay(pageLoadTime);
//		}catch(Exception buttonNotFound) {
//			Log.error("Unable to add new customer  --  Please check with UI Locators");
//		}
//		customerAlreadyExists();
//	}
//	private static void customerAlreadyExists() {
//		Synchronise.delay(pageLoadTime);
//		try {
//			driver.findElement(By.xpath(UILocators.OrdersPage.continueButtonAlreadyExists_xpath)).click();
//			Log.error("Customer already found, moving forward with the same customer");
//		}catch(Exception customerNotFound){
//			Log.info("Registering new Customer");
//		}
//	}
//	private static void enterNewCustomerDetails(String name, String email,String password, String phone) {
//		try {
//			Log.info("Creating new user with name - ");
//			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerName_xpath)).sendKeys(name);
//			Log.info("Entering name - " + name);
//			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerEmail_xpath)).sendKeys(email);
//			Log.info("Entering email id - " + email);
//			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerPassword_xpath)).sendKeys(password);
//			Log.info("Entering passsword - **********");
//			driver.findElement(By.xpath(UILocators.OrdersPage.newCustomerPhone_xpath)).sendKeys(phone);
//			Log.info("Entering phone number - " + phone);
//			driver.findElement(By.xpath(UILocators.OrdersPage.addNewCustomerButton_xpath)).click();
//			Log.info("Click on Add Button");
//		}catch(Exception formNotAvailable) {
//			Log.error("Unable to add new customer");
//		}
//	}
	protected static void selectDeliveryMethod(String deliveryMethod) {
		try {
			if(deliveryMethod.equalsIgnoreCase("take away"))
				driver.findElement(By.id(UILocators.OrdersPage.takeAwayDeliveryMethod_id)).click();
			else if(deliveryMethod.equalsIgnoreCase("pick and drop"))
				driver.findElement(By.id(UILocators.OrdersPage.pickAndDropDeliveryMethod_id)).click();
			else {
				driver.findElement(By.id(UILocators.OrdersPage.homeDeliveryMethod_id)).click();
				deliveryMethod = "Home Delivery";
			}
			Log.info("Selecting delivery method as - " + deliveryMethod);
		}catch(Exception unableToSetDeliveryMethod) {
			Log.error("Unable to set delivery method,setting it to default delivery type!");
		}
	}
	protected static void selectMerchant(String merchant) {
		try {
			driver.findElement(By.xpath(UILocators.OrdersPage.selectMerchant_xpath)).sendKeys(merchant);
			Log.info("Entering merchant name - " + merchant);
			Synchronise.delay(pageLoadTime/5);
			driver.findElement(By.xpath(UILocators.OrdersPage.selectMerchantDropDown_xpath1 + merchant + UILocators.OrdersPage.selectMerchantDropDown_xpath2)).click();
		}catch(Exception unableToAddMerchant) {
			Log.error("Unable to add merchant");
		}
	}
	protected static void enterProductName(String product) {
//		try {
		Synchronise.delay(pageLoadTime/5);
			driver.findElement(By.xpath(UILocators.OrdersPage.enterProducts_xpath)).sendKeys(product);
			Synchronise.delay(pageLoadTime/5);
			driver.findElement(By.xpath(UILocators.OrdersPage.selectProductDropDown_xpath1 + product + UILocators.OrdersPage.selectProductDropDown_xpath2)).click();
			Log.info("Adding product - " + product + "to the list");
//		}catch(Exception ElementNotFound) {
//			Log.error("unable to add products OR the mentioned product is not available");
//		}
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
			Synchronise.delay(pageLoadTime);
			driver.findElement(By.xpath(UILocators.OrdersPage.createOrderFinalButton_xpath)).click();
			driver.findElement(By.xpath(UILocators.OrdersPage.createOrderFinalButton_xpath)).getText();
			Log.info("The page says " + driver.findElement(By.xpath(UILocators.OrdersPage.createOrderFinalButton_xpath)).getText());
			Log.info("Click on create order");
			return true;
		}catch(Exception ex) {
			Log.error("Unable to click on create order button");
			return false;
		}
	}
	protected static boolean validateCreatedOrder() {
		int findPopUpCount = 0;
		if(driver.getPageSource().contains("This field is required.")) {
			Log.error("Create Order Failed. Please check with administrator account for further queries");
			return false;
		}
		while(findPopUpCount++ < 10) {
			try {
				driver.getPageSource().contains("Order Placed Successfully");
				Log.info("Order successfull - Validated");
				return true;
			}catch(Exception popUpNotFound) {
				Synchronise.delay(500);
				if(findPopUpCount == 9) {
					Log.error("Unable to see order succesfull validation pop-up");
					return false;
				}
			}
		}
		return false;
	}
	protected static void selectDeliveryOption(String deliveryOption) {
		try {
			if(deliveryOption.equalsIgnoreCase("ondemand")) {
				driver.findElement(By.id(UILocators.OrdersPage.deliveryOptionOnDemand_id)).click();
				Log.info("Selecting On Demand as a delivery option");
			}else {
				driver.findElement(By.id(UILocators.OrdersPage.deliveryOptionScheduled_id)).click();
				Log.info("Selecting Scheduling as a delivery option");
			}
		}catch(Exception unableToSetDeliveryStatus) {
			Log.error("Unable to set delivery status, kepping it to the default choice!");
		}
	}
}