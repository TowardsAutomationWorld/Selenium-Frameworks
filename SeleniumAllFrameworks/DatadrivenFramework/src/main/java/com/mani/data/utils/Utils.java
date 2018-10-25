package com.mani.data.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

	public static Properties properties;
	public static FileInputStream fileInputStream;

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

}
