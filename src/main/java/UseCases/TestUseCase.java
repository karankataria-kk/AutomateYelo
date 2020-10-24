package UseCases;

import org.openqa.selenium.WebDriver;

import LogHandler.Log;
import WebDrivers.Drivers;

/*
 * This is a test use case file, to run and check what we get after the execution of the
 * test scripts in the framework
 */
public class TestUseCase {
	public static void main(String args[]) {
		System.out.println("Test print");
		Log.info("Test info message");
		Drivers drv = new Drivers();
		drv.initialiseWebDriver();
		Log.error("Test error");
	}
}
