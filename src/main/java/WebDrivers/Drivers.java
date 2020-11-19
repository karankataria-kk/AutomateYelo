package WebDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Configuration.Config;
import ExcelHandler.ExcelFileHandling;
import LogHandler.Log;

/*
 * This file contains the Web Driver Initialization and contains reference to all the kind of
 * web browser's drivers which are compatible with the framework.
 */
public class Drivers extends ExcelFileHandling{
	protected static WebDriver driver;
	protected String browser;
	protected String url = Config.getProperty("URL");
	private static String chromeDriverPath =  "src\\main\\Resources\\Drivers\\chromedriver.exe";
	protected boolean closeBrowser() {
		driver.quit();
		return true;
	}
	protected boolean lauchBrowser(String URL) {
		driver.get(URL);
		return true;
	}
	protected static boolean initialiseWebDriver() {
		if(Config.getProperty("webdriver").equalsIgnoreCase("chrome")) {
			try {	
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				driver = new ChromeDriver();
				Log.info("Setting Chrome driver");
			}catch (Exception unableToIntialise) {
				Log.error("Unable to initialise Web Driver");
			}
			return true;
		}else if(Config.getProperty("webdriver").equalsIgnoreCase("firefox")) {

		}else if(Config.getProperty("webdriver").equalsIgnoreCase("edge")) {

		}else
			Log.error("Enter correct driver name and informtion in Configurations file");
		driver.manage().window().maximize();
		return false;
	}
}