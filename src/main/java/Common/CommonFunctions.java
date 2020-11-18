package Common;

import LogHandler.Log;

/*
 * This file contains any kind of common functions which needs to be 
 * used through out the framework to get the re-usablity of the code to its best.
 */
public class CommonFunctions {
	static int testCaseNumber = 0;
	public static void printTestInfo(String testId) {
		CommonFunctions.printTestCaseHeader();
		CommonFunctions.printTestId(testId);
	}
	private static void printTestCaseHeader() {
		Log.info("**** Test Case " + ++testCaseNumber + " ****");
	}
	private static void printTestId(String testId) {
		Log.info("<<" + testId + ">>");
	}
}
