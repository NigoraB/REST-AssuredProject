package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_xlsx {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils_xlsx(String excelPath, String sheetName) {
	
		try {
			
			 workbook = new XSSFWorkbook(excelPath);
			 sheet = workbook.getSheet(sheetName);
			
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());

			exp.printStackTrace();
		}
		
	}

	public static void getCellData(int rowNum, int colNum) {
	
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println(value);		
	}

	public static void getRowCount() {
	
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of Rows" + rowCount);

	}

}
