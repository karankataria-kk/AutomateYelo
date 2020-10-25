package UseCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import LogHandler.Log;
import PageObject.PageObject;
import TestScript.TestLogin;

/*
 * This is a test use case file, to run and check what we get after the execution of the
 * test scripts in the framework
 */
public class TestUseCase extends PageObject{
	public static void main(String args[]) {
		PageObject.init();
		TestLogin.login();
	}
}
