package com.mani.data.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public static Properties properties;
	public static FileInputStream fileInputStream;
	private static XSSFWorkbook workbook;
	private static FileInputStream file;
	private static List<String> columnsValues;
	private static XSSFSheet sheet;
	private static Row row;
	private static Cell col;

	public static void OrFileReading() throws IOException {
		properties = new Properties();
		fileInputStream = new FileInputStream(AppConstants.OR_FILE_PATH);
		properties.load(fileInputStream);
		String mobileTesting = properties.getProperty("MobileTesting");
	}

	public static void configFileReading() throws IOException {
		properties = new Properties();
		fileInputStream = new FileInputStream(AppConstants.CONFIG_FILE_PATH);
		properties.load(fileInputStream);
		String mobileTesting = properties.getProperty("MobileTesting");
	}

	public static String now(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat();
		return fm.format(cal.getTime());
	}

	public static List<String> readExcelFile(String filePath, String SheetName, int columnNumber) {
		columnsValues = new ArrayList<String>();
		try {
			file = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(SheetName);

			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getLastRowNum(); i++) {
					row = CellUtil.getRow(i, sheet);
					col = CellUtil.getCell(row, columnNumber);
					columnsValues.add(col.getStringCellValue());
					if (i == sheet.getLastRowNum()) {
						break;
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error entrada/salida");
		}
		return columnsValues;
	}

}
