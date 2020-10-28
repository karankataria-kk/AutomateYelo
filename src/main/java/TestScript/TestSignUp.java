package TestScript;

import Configuration.Config;
import Scripts.Yelo.SignUp;

public class TestSignUp extends SignUp{
	static String name = Config.getProperty("signup.name");
	static String emailId = Config.getProperty("signup.email");
	static String password = Config.getProperty("signup.password");
	static String contact = Config.getProperty("signup.contact.number");
	static String buisnessName = Config.getProperty("signup.buisness.name");
	static String buisnessIdea = Config.getProperty("signup.buisness.idea");
	public static void SignUp(){
		SignUp.navigateToSignUpPage();
		if(SignUp.enterDetails(name, emailId, password, contact))
			if(SignUp.enterBuisenessName(buisnessName))
				chooseBuisnessIdea(buisnessIdea);
			
	}
}
