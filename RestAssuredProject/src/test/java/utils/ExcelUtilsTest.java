package utils;

public class ExcelUtilsTest {

	public static void main(String[] args) {
		
		String excelPath= "./data/TestData.xlsx";
		String sheetName= "Sheet1";
	
		ExcelUtils_xlsx excel = new ExcelUtils_xlsx(excelPath, sheetName);
		excel.getRowCount();
		excel.getCellData(1,0);
		excel.getCellData(1,1);
		excel.getCellData(1,2);
		
		
//		ExcelUtils_xls exc = new ExcelUtils_xls(excelPath, sheetName);
//		exc.getRowCount();
//		exc.getCellData(1,0);
//		exc.getCellData(1,1);
//		exc.getCellData(1,2);
	}

}
