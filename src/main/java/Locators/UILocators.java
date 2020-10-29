package Locators;

public class UILocators {
	public static final class LoginPage{
		public static final String userName_xpath = "//input[@type='email'][@name='email']";
		public static final String password_xpath = "//input[@type='password'][@name='password']";
		public static final String loginButton_xpath = "//button[text()='Login']";
	}
	public static final class SignUpPage{
		public static final String nameInput_xpath = "//input[@placeholder='Enter Name']";
		public static final String emailInput_xpath = "//input[@placeholder='Enter Email']";
		public static final String passwordInput_xpath = "//input[@placeholder='Enter Password']";
		public static final String contactNumberInput_xpath = "//*[@id=\"companyPhone\"]/div/input";
		public static final String continueButton_xpath = "//button[contains(text(),'Continue')]";
		public static final String buisnessNameInput_xpath = "//input[@autocomplete='off']";
		public static final String nextButton_xpath = "//button[contains(text(),'Next')]";
		public static final String UILocatorBuisnessIdea_part1 = "//span[contains(normalize-space(),'";
		public static final String UILocatorBuisnessIdea_part2 = "')]";
		public static final String UILocatorBuisnessIdeaOthers_xpath = "//span[contains(normalize-space(),'Others')]";
	}
	public static final class HomePage{
		public static final String logOutButton_xpath = "";
	}
}

