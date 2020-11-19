package Scripts.Yelo;

import org.openqa.selenium.By;

import Locators.UILocators;
import LogHandler.Log;
import PageObject.PageObject;
import Synchronisation.Synchronise;

public class ApproveOrder extends PageObject{
	protected static void navigateToOrdersTab() {
		CreateOrder.navigateToOrders();
	}
	protected static void choosePendingOrderInFilter() {
		try {
			Synchronise.delay(pageLoadTime);
			driver.findElement(By.xpath(UILocators.OrdersPage.filterDropDown_xpath)).click();
			Log.info("Click on filter dropdown");
			Synchronise.delay(pageLoadTime/5);
			driver.findElement(By.xpath(UILocators.OrdersPage.pendingOptionFilter_xpath)).click();
		}catch(Exception filterNotAvailable) {
			Log.error("Unable to set filter");
		}
	}
	protected static void completeLatestOrder() {
		try {
			Synchronise.delay(pageLoadTime);
			driver.findElement(By.xpath((UILocators.OrdersPage.firstOrderStatus_xpath))).click();
			Log.info("Click on order status button");
			driver.findElement(By.xpath(UILocators.OrdersPage.completedOrderButton_xpath)).click();
			Log.info("Selecting completed order button");
		}catch(Exception unableToChangeOrderStatus) {
			Log.error("Getting difficulty in changing the order status");
		}
	}
	protected static boolean validateOrderCompletion() {
		int validateRepeatCheck = 0;
		try {
			while(validateRepeatCheck < 10) {
				driver.getPageSource().contains("Successful");
				Log.info("Validation - Order Completed! - Successful");
				return true;
			}
		}catch(Exception validationMessageNotFound) {
			if(validateRepeatCheck == 9) {
				Log.error("Unable to validate the Successful message");
				return false;
			}
		}
		return true;
	}
}
