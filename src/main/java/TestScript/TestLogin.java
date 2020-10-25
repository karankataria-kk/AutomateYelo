package TestScript;

import Configuration.Config;
import Scripts.Yelo.LoginPage;
public class TestLogin {
	static LoginPage loginTo = new LoginPage();
	static String homePageURL = Config.getProperty("homepage.url");
	static String userID = Config.getProperty("user.id");
	static String password = Config.getProperty("password");
	public static boolean login() {
		LoginPage.launchHomePage(homePageURL);
		loginTo.addCredentials(userID, password);
		loginTo.loginingIn();
		return false;
	}
}
