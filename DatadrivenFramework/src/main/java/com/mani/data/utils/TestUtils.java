package com.mani.data.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TestUtils {

	/*public static void getScreenShot(String fileName) throws IOException {
		File outputFile = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(outputFile,new File(System.getProperty("user.dir")+"//src//main//java//KeywordDriven//Selenium//Screenshot//"+fileName+".jpg"));
	}*/

	public static String now(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat();
		return fm.format(cal.getTime());
	}
	
	
}
