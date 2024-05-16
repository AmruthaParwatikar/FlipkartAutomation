package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
    
	public static String getTestData(String filePath, int sheetIndex, String columnName, int rowIndex) throws Exception {
	    File src = new File(filePath);
	    FileInputStream fis = new FileInputStream(src);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

	    int columnIndex = -1;
	    XSSFRow headerRow = sheet.getRow(0); // Assuming the header row is the first row
	    for (int i = 0; i < headerRow.getLastCellNum(); i++) {
	        if (headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
	            columnIndex = i;
	            break;
	        }
	    }

	    if (columnIndex == -1) {
	        throw new IllegalArgumentException("Column '" + columnName + "' not found in the Excel sheet.");
	    }

	    XSSFRow dataRow = sheet.getRow(rowIndex);
	    if (dataRow == null) {
	        throw new IllegalArgumentException("Row " + rowIndex + " not found in the Excel sheet.");
	    }

	    XSSFCell cell = dataRow.getCell(columnIndex);
	    if (cell == null) {
	        throw new IllegalArgumentException("No data found in column '" + columnName + "' for row " + rowIndex);
	    }

	    String cellValue = cell.getStringCellValue();
	    workbook.close();
	    return cellValue;
	}
}