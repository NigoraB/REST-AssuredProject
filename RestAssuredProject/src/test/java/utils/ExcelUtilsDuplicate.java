package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsDuplicate {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtilsDuplicate(String excelPath, String sheetName) {
	
		try {
			
			 workbook = new XSSFWorkbook(excelPath);
			 sheet = workbook.getSheet(sheetName);
			
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());

			exp.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {

		getRowCount();
		getCellData();
	}

	public static void getCellData() {

		try {

			//String excelPath = "./data/TestData.xlsx";

			
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(1).getCell(2));
			//String value1 = sheet.getRow(1).getCell(0).getStringCellValue();
			// double value2 =sheet.getRow(1).getCell(2).getNumericCellValue();
			//System.out.println(value1);
			// System.out.println(value2);
			System.out.println(value);
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());

			exp.printStackTrace();
		}

	}

	public static void getRowCount() {

		try {

//			String projectDirectory = System.getProperty("user.dir");
//			System.out.println(projectDirectory);

//			String excelPath = "./data/TestData.xlsx";
//
//			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
//			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of Rows" + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());

			exp.printStackTrace();
		}

	}

}
