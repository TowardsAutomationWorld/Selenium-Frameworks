package com.mani.data.config;

import java.io.FileInputStream;
import java.util.Properties;

import com.mani.data.utils.AppConstants;

public class GlobalConfigurations {

	public Properties properties;
	public FileInputStream fileInputStream;
	private static GlobalConfigurations sglobalConfigInstance = null;

	public String applicationURL;
	public String chromeDriverPath;
	public String firefoxDriverPath;
	public String IEDriverPath;
	public String chromefoxDriverInitalValue;
	public String firefoxDriverInitalValue;
	public String IEDriverInitalValue;
	public String browserType;

	private GlobalConfigurations() {
		try {
			properties = new Properties();
			fileInputStream = new FileInputStream(AppConstants.CONFIG_FILE_PATH);
			properties.load(fileInputStream);

			applicationURL = properties.getProperty("App_Url");
			chromeDriverPath = AppConstants.Project_Base_Path + properties.getProperty("Chrome_Driver_Path");
			firefoxDriverPath = AppConstants.Project_Base_Path + properties.getProperty("Firefox_Driver_path");
			IEDriverPath = AppConstants.Project_Base_Path + properties.getProperty("IE_Driver_path");
			chromefoxDriverInitalValue = properties.getProperty("Chrome_Driver_Inital_Path");
			firefoxDriverInitalValue = properties.getProperty("Firefox_Driver_Inital_Path");
			IEDriverInitalValue = properties.getProperty("IE_Driver_Inital_Path");
			browserType = properties.getProperty("Browser_Type");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static GlobalConfigurations getInstance() {
		if (sglobalConfigInstance == null) {
			sglobalConfigInstance = new GlobalConfigurations();
		}
		return sglobalConfigInstance;
	}

}
