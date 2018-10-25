package com.mani.data;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mani.data.config.GlobalConfigurations;

public class TestBase {
	public WebDriver driver;
	public FileInputStream reader;
	public XSSFWorkbook workbook;
	public XSSFSheet workSheet;
	public ExcelReader excelReader;

	@BeforeClass
	@Parameters("browserType")
	public void setUp(String browserType) {
		GlobalConfigurations globalConfig = GlobalConfigurations.getInstance();

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty(globalConfig.chromefoxDriverInitalValue, globalConfig.chromeDriverPath);
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {

			System.setProperty(globalConfig.firefoxDriverInitalValue, globalConfig.firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(GlobalConfigurations.getInstance().applicationURL);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	public String[][] getData(String excelName, String sheetName) {
		excelReader = new ExcelReader();
		return excelReader.getExcelData(excelName, sheetName);
	}

}
