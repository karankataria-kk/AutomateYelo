package UseCases;

import PageObject.PageObject;
import TestScript.TestCreateOrder;
import TestScript.TestLogin;

/*
 * This is a test use case file, to run and check what we get after the execution of the
 * test scripts in the framework
 */
public class TestUseCase extends PageObject{
	public static void main(String args[]) {
		PageObject.init();
		//TestSignUp.signUp();
		TestLogin.login();
		TestCreateOrder.creationOfOrder();
	}
}
