package UseCases;

import org.testng.annotations.Test;

import Common.CommonFunctions;
import PageObject.PageObject;
import Scripts.Yelo.ApproveOrder;
import TestScript.TestApproveOrder;
import TestScript.TestCreateOrder;
import TestScript.TestLogin;
import TestScript.TestSignUp;

import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class TestSuite1 {

	@BeforeSuite
	public void beforeSuite() {
		PageObject.init();
	}
	@BeforeMethod
	public void beforeMethod() {
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
	public void AcceptOrder() {
		Assert.assertTrue(TestApproveOrder.approveOrder(),"Order Not Accepted,Kindly check with UILocators");
	}
	@AfterMethod
	public void afterMethod() {
		CommonFunctions.printSeparator();
	}
	@AfterSuite
	public void afterSuite() {
		PageObject._init();
	}

}
