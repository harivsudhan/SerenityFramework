package com.taf.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import au.com.bytecode.opencsv.CSVReader;

public class ExcelUtilities {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	private int col_Num;
	private int rowNum;
	private String sheetName;
	private CSVReader reader;

	public ExcelUtilities(String xlFilePath, String sheetName) throws Exception {
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		this.sheetName = sheetName;
		fis.close();
	}

	public ExcelUtilities(String csvFilePath) {
		try {
			reader = new CSVReader(new FileReader(csvFilePath));
		} catch (FileNotFoundException e) {
			Assert.fail(e.getMessage());
		}
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

	public int read() {
		int size = 0;
		try {
			List<String[]> myEntries = reader.readAll();
			System.out.println("The length of the file is " + myEntries.size());
			size = myEntries.size();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return size;
	}

}