package Synchronisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import LogHandler.Log;
import PageObject.PageObject;

/*
 * This file contains the waiting functions as per the need... This helps the web page and code scripts
 * to synchronize with each other
 */
public class Synchronise extends PageObject{
	public static boolean isDisplayed(WebElement element) {
		boolean isPresent =false;
		if(element.isDisplayed()) 
			isPresent = true;
		return isPresent;
	}
	public static boolean isClicakble(String type , String locator) {
		boolean isClickable = false;
		WebElement element = null;
		if(type.equalsIgnoreCase("xpath"))
			element = driver.findElement(By.xpath(locator));
		if(type.equalsIgnoreCase("className"))
			element = driver.findElement(By.className(locator));
		if(type.equalsIgnoreCase("cssSelector"))
			element = driver.findElement(By.cssSelector(locator));
		if(type.equalsIgnoreCase("id"))
			element = driver.findElement(By.id(locator));
		if(type.equalsIgnoreCase("linkText"))
			element = driver.findElement(By.linkText(locator));
		if(type.equalsIgnoreCase("name"))
			element = driver.findElement(By.name(locator));
		if(isDisplayed(element)) 
			if(element.isEnabled())
				isClickable = true;
		return isClickable;
	}
	public static void delay(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Log.error("Unable to add delay");
		}
	}
}