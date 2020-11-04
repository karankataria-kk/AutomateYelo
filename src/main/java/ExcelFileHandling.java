
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Configuration.Config;
import LogHandler.Log;

public class ExcelFileHandling {
	static boolean excelFileAttachmentStatus = false;
	static String fileLocation = Config.getProperty("excel.sheet.location");
	static XSSFSheet sheet;
	protected static void excelIntegration(int sheetNumberIndex) {
		if(fileLocation != null)
			if(!excelFileAttachmentStatus)
				if(excelFileReadableStatus(fileLocation) != null)
					excelFileAttachmentStatus = true;
		excelFileAttachmentStatus = false;
	}
	protected static XSSFSheet setWorkBookAtIndex(int sheetNumberIndex) {
		/*
		 * You can directly call this function to edit or get the data from
		 * the excel file attached
		 * 
		 * FYI - This will return a null value when ever you are going to call it
		 * without any file attached
		 */
		try {
			XSSFWorkbook accessYeloData = new XSSFWorkbook();
			sheet = accessYeloData.getSheetAt(sheetNumberIndex);
			Log.info("Using excel sheet at index - " + sheetNumberIndex);
			return sheet;
		}catch(Exception sheetNotFound) {
			Log.error("No sheet found at index - " + sheetNumberIndex);
			return null;
		}
	}
	private static FileInputStream excelFileReadableStatus(String fileLocation) {
		try {
			FileInputStream inputStream = new FileInputStream(fileLocation);
			Log.info("Excelfile attached - " + fileLocation);
			return inputStream;
		} catch (FileNotFoundException e) {
			Log.error("Excel file not Found at given file folder - " + fileLocation);
			return null;
		}

	}
}
