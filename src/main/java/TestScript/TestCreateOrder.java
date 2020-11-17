package TestScript;

import Configuration.Config;
import Scripts.Yelo.CreateOrder;

public class TestCreateOrder extends CreateOrder{
	static String customerName = Config.getProperty("customer.name");
//	static String newCustomerEmail = Config.getProperty("new.customer.email");
//	static String newCustomerPassword = Config.getProperty("new.customer.password");
//	static String newCustomerPhone = Config.getProperty("new.customer.phone");
	static String deliveryMethod = Config.getProperty("order.delivery.method");
	static String merchant = Config.getProperty("order.from.merchant");
	static String product = Config.getProperty("order.product.name");
	static String suggestions = Config.getProperty("order.suggesstions");

	public static void creationOfOrder() {
		CreateOrder.navigateToOrders();
		CreateOrder.createOrderProcess();
		CreateOrder.selectCustomer(customerName);
//		CreateOrder.addNewCustomer(addNewCustomerName, newCustomerEmail, newCustomerPassword, newCustomerPhone);
		CreateOrder.selectDeliveryMethod(deliveryMethod);
		CreateOrder.selectMerchant(merchant);
		CreateOrder.enterProductName(product);
		CreateOrder.enterSuggestions(suggestions);
		CreateOrder.checkInvoice();
		CreateOrder.createOrder();
		CreateOrder.validateCreatedOrder();
	}
}
