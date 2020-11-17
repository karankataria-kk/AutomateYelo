package Locators;

public class UILocators {
	public static final class CustomersPage{
		public static final String noDataAvailableRow_xpath = "//td[normalize-space()='No Data Available']";
		public static final String searchBar_xpath = "//input[@placeholder='Search']";
	}
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
		public static final String notificationBarLoginChck_xpath = "//div[@class='mobile']";
		public static final String logOutButton_xpath = "";
	}
	public static final class LeftPane{
		public static final String ordersButton_xpath = "//li[normalize-space()='Orders']";
		public static final String customersPage_xpath = "//li[normalize-space()='customers']";
	}
	public static final class OrdersPage{
		public static final String createOrderButton_xpath = "//button[contains(text(),'Create Order')]";
		public static final String selectCustomer_xpath = "//input[@placeholder='Customer']";
		public static final String selectCustomerDropDown_xpath1 = "//span[contains(normalize-space(),'";
		public static final String selectCustomerDropDown_xpath2 = "')]//div";
		public static final String customerNameList_xpath = "//ul[@role='listbox']";
		public static final String addNewCustomerButton_xpath = "//div//i[@class='fa fa-plus-circle ng-tns-c32-35 ng-star-inserted']";
		public static final String newCustomerName_xpath = "//input[@placeholder='Enter Name']";
		public static final String newCustomerEmail_xpath = "//input[@placeholder='Enter Email']";
		public static final String newCustomerPassword_xpath = "//input[@placeholder='Enter Password']";
		public static final String newCustomerPhone_xpath = "//int-phone-prefix[@placeholder='Enter Phone No.']";
		public static final String newCustomerAddButton_xpath = "//button[normalize-space()='Add']";
		public static final String takeAwayDeliveryMethod_xpath = "//label[@for='delivery-method-2'";
		public static final String homeDeliveryMethod_xpath = "//label[@for='delivery-method-1'";
		public static final String pickAndDropDeliveryMethod_xpath = "//label[@for='delivery-method-3'";
		public static final String selectMerchant_xpath = "//input[@placeholder='Merchant']";
		public static final String enterProducts_xpath = "//p-autocomplete[@class='ng-tns-c30-20 ng-tns-c23-22 ng-valid ng-touched ng-dirty']";
		public static final String addSuggestions_xpath = "//textarea[@placeholder='Any Suggestions?']";
		public static final String invoiceButton_xpath = "//button[normalize-space()='Invoice']";
		public static final String createOrderFinalButton_xpath = "button[class='btn btn-yl-primary']";
		public static final String orderSucessfullPopUp_xpath = "//div[@class='ui-toast-message-text-content ng-tns-c5-27 ng-star-inserted']";
		public static final String continueButtonAlreadyExists_xpath = "//button[normalize-space()='Continue']";
	}
}

