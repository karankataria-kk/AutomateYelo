package Locators;

public class UILocators {
	public static final class LoginPage{
		public static final String userName_xpath = "//input[@type='email'][@name='email']";
		public static final String password_xpath = "//input[@type='password'][@name='password']";
		public static final String loginButton_xpath = "//button[text()='Login']";
	}
	public static final class SignUpPage{
		public static final String nameInput_xpath = "//input[@placeholder='Enter Name']";
		public static final String passwordInput_className = "form-group input-container input-img-email signup_via_otp";
		public static final String emailInput_className = "form-group input-container input-img-password signup_via_otp";
		public static final String contactNumberInput_className = "pl-0 focusable phone-new-field ng-untouched ng-pristine ng-invalid";
		public static final String continueButton_className = "continue-btn-desktop mt-4 cursor-disabled";
	}
}

