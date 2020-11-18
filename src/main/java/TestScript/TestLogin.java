package TestScript;

import Common.CommonFunctions;
import Configuration.Config;
import Scripts.Yelo.LoginPage;
public class TestLogin extends LoginPage{
	static String homePageURL = Config.getProperty("homepage.url");
	static String userID = Config.getProperty("user.id");
	static String password = Config.getProperty("password");
	public static boolean login() {
		CommonFunctions.printTestInfo("AY002 -- Log In");
		LoginPage.launchHomePage(homePageURL);
		LoginPage.addCredentials(userID, password);
		LoginPage.loginingIn();
		return LoginPage.validateLogin();
	}
}
