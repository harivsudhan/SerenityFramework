package com.taf.utils;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	private int col_Num;
	private int rowNum;
	private String sheetName;

	public ExcelUtilities(String xlFilePath, String sheetName) throws Exception {
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		this.sheetName = sheetName;
		fis.close();
	}

	public int getRowCount() {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int getColumnCount() {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	public String getCellData(String rowName, String colName) {
		try {
			sheet = workbook.getSheet(sheetName);
			int columnCount = getColumnCount();
			int rowCount = getRowCount();

			for (int i = 0; i < columnCount; i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					col_Num = i;
					break;
				}
			}
			
			for (int i = 0; i < rowCount; i++) {
				row = sheet.getRow(i);
				String cellValue = row.getCell(0).toString().trim();
				if (cellValue != null) {
					if (cellValue.contentEquals(rowName.trim())) {
						rowNum = i;
						break;
					}
				}
			}
			row = sheet.getRow(rowNum);
			cell = row.getCell(col_Num);
			if (!(cell == null)) {
				if (cell.getCellType() == CellType.STRING)
					return cell.getStringCellValue();
				else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
					String cellValue = String.valueOf(cell.getNumericCellValue());
					if (DateUtil.isCellDateFormatted(cell)) {
						DateFormat df = new SimpleDateFormat("dd/MM/yy");
						Date date = cell.getDateCellValue();
						cellValue = df.format(date);
					}
					return cellValue;
				} else
					return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + col_Num + " does not exist  in Excel";
		}
		return "";
	}
}