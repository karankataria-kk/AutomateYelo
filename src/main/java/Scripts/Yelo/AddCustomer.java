package Scripts.Yelo;

import org.openqa.selenium.By;

import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;
import Synchronisation.Synchronise;

public class AddCustomer extends PageObject{
	protected static void navigateToCustomersPage() {
		try{
			driver.findElement(By.xpath(UILocators.LeftPane.customersPage_xpath)).click();
			Log.info("Navigating to customers page");
		}catch(Exception buttonNotFound) {
			Log.error("Unableto navigate to \"Customers\" page");
		}
	}
	protected static void checkCustomerData() {
		Synchronise.delay(pageLoadTime);
		try {
			driver.findElement(By.xpath(UILocators.CustomersPage.noDataAvailableRow_xpath));
			Log.info("<<--No Data Available in customers list-->>");
		}catch(Exception dataAvailable) {
			Log.info("There are some of the customers already registered with us");
		}
	}
	protected static void searchCustomerName(String custName) {
//		try {
//			driver.findElement(By.xpath(UILocators.CustomersPage.searchBar_xpath)).sendKeys(custName);
//		}
	}
}
