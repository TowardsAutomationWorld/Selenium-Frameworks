package com.mani.data.threading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ThreadsParallelExecutor {

	private static final int noOFThreads = 1;
	private static XSSFWorkbook workbook;
	private static FileInputStream file;
	private static List<String> columnsValues;
	private static List<String> allTestCaseValues;
	private static List<String> allTestCaseDescriptionsValues;
	private static List<String> allKeyWordValuesValues;
	private static XSSFSheet sheet;
	private static Row row;
	private static Cell col;

	public static void main(String[] args) throws InvalidFormatException, IOException {/*

		String startTime = TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa");
		ReportUtil.startTesting(System.getProperty("user.dir") + "//reports//index.html", startTime, "Test", "1.5");

		ReportUtil.startSuite("Suite1");

		allTestCaseValues = readExcelFile("G:\\Git_Repository\\ThreadsParallelExecution\\data\\TestCases.xlsx", "TC02",
				0);
		allTestCaseDescriptionsValues = readExcelFile(
				"G:\\Git_Repository\\ThreadsParallelExecution\\data\\TestCases.xlsx", "TC02", 1);

		allKeyWordValuesValues = readExcelFile("G:\\Git_Repository\\ThreadsParallelExecution\\data\\TestCases.xlsx",
				"TC02", 2);

		ExecutorService executor = Executors.newFixedThreadPool(noOFThreads);
		for (int i = 0; i < allTestCaseValues.size(); i++) {
			String url = allTestCaseValues.get(i);
			Runnable worker = new WorkerThread(url);
			executor.execute(worker);

			if (i <= 0) {
				for (int j = 0; j < allTestCaseDescriptionsValues.size(); j++) {
					ReportUtil.addTestCase(allTestCaseDescriptionsValues.get(j), startTime,
							TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"), "Pass");

					for (int k = 0; k < allTestCaseDescriptionsValues.size(); k++) {
						
						ReportUtil.addKeyword(allTestCaseDescriptionsValues.get(k), allKeyWordValuesValues.get(k), "Pass", null);
					}
				}
			}

		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
//		ReportUtil.addKeyword("Navigate to page", "Navigate", "Pass", null);
		// ReportUtil.addTestCase("TopNavigation", startTime,
		// TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"), "Pass");

		ReportUtil.endSuite();
		ReportUtil.updateEndTime(TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"));
	*/}

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
