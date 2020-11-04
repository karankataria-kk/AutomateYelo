package PageObject;

import Configuration.Config;
import ExcelHandler.ExcelFileHandling;
import LogHandler.Log;
import WebDrivers.Drivers;

public class PageObject extends Drivers{
	static String logFilePath = "src\\main\\java\\LogHandler\\log4j.xml";
	static String pageLoadingTime = Config.getProperty("page.load.time");
	static String homePageURL = Config.getProperty("homepage.url");
	protected static int pageLoadTime = Integer.parseInt(pageLoadingTime);
	protected static String excelFilePath = Config.getProperty("excel.sheet.location");
	protected static int sheetNumberIndex = 0;
	public static void init() {
		Log.initializeLog(Log.class, logFilePath);
		Drivers.initialiseWebDriver();
		ExcelFileHandling.excelIntegration(sheetNumberIndex);	
		navigateToHomePage();
	}
	public static void navigateToHomePage() {
		driver.get(homePageURL);
		Log.info("Navigating to Home page --> " + homePageURL);
		try {
			Thread.sleep(PageObject.pageLoadTime);
			Log.info("Encountered alert - " + driver.switchTo().alert().getText());
			driver.switchTo().alert().dismiss();
			Log.info("Accepting alert");
		}catch(Exception noAlertPresent) {
			Log.info("Alert handling - No alert present");
		}
	}
}