package PageObject;

import LogHandler.Log;
import WebDrivers.Drivers;

public class PageObject extends Drivers{
	static String logFilePath = "src\\main\\java\\LogHandler\\log4j.xml";
	public static void init() {
		Log.initializeLog(Log.class, logFilePath);
		Drivers.initialiseWebDriver();
	}
}
