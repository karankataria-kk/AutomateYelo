package TestScript;

import Common.CommonFunctions;
import PageObject.PageObject;
import Scripts.Yelo.ApproveOrder;

public class TestApproveOrder extends ApproveOrder{
	public static boolean approveOrder() {
		CommonFunctions.printTestInfo("AY004 - Approve Order");
		ApproveOrder.navigateToOrdersTab();
		//ApproveOrder.choosePendingOrderInFilter();
		ApproveOrder.completeLatestOrder();
		return ApproveOrder.validateOrderCompletion();
	}
}
