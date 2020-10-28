package TestScript;

import Configuration.Config;
import Scripts.Yelo.SignUp;

public class TestSignUp extends SignUp{
	static String name = Config.getProperty("signup.name");
	public static void SignUp(){
		SignUp.navigateToSignUpPage();
		SignUp.enterDetails(name);
	}
}
