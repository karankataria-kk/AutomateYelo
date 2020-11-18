package UseCases;

import org.testng.annotations.Test;

import PageObject.PageObject;
import TestScript.TestCreateOrder;
import TestScript.TestLogin;
import TestScript.TestSignUp;

import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class TestSuite1 {

	@BeforeSuite
	public void beforeSuite() {
		PageObject.init();
	}
	@BeforeMethod
	public void beforeTest() {
		PageObject.navigateToHomePage();
	}
	@Test(priority = 1)
	public void SignUp() {
		TestSignUp.signUp();
	}
	@Test(priority = 2)
	public void LogIn() {
		Assert.assertTrue(TestLogin.login(),"UNABLE TO LOGIN -- TEST CANNOT PROCEED");
	}
	@Test(priority = 3)
	public void CreateOrder() {
		Assert.assertTrue(TestCreateOrder.creationOfOrder());
	}
	@Test(priority = 4)
	public void acceptOrder() {
		
	}
	@AfterSuite
	public void afterSuite() {
	//	PageObject._init();
	}

}
