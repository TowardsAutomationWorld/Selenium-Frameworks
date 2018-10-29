package com.mani.data;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	public void setUpBrowser(String browserType) throws MalformedURLException {
		
		GlobalConfigurations globalConfig = GlobalConfigurations.getInstance();

		if (System.getProperty("os.name").contains("Mac")) {
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty(globalConfig.chromefoxDriverInitalValue, globalConfig.chromeDriverPath);
				System.out.println(" Mac OS Executing on Chrome Browser");
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("firefox")) {
				System.setProperty(globalConfig.firefoxDriverInitalValue, globalConfig.firefoxDriverPath);
				System.out.println(" Mac OS Executing on FireFox Browser");
				driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase("safari")) {
				System.setProperty("webdriver.safari.driver", "Safari driver path");
				System.out.println(" Mac OS Executing on Safari Browser");
				driver = new InternetExplorerDriver();
			}
		} else if (System.getProperty("os.name").contains("Window")) {
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty(globalConfig.chromefoxDriverInitalValue, globalConfig.chromeDriverPath);
				System.out.println(" Windows OS Executing on Chrome Browser");
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty(globalConfig.firefoxDriverInitalValue, globalConfig.firefoxDriverPath);
				System.out.println(" Windows OS  Executing on Firefox Browser");
				driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase("ie")) {
				System.setProperty(globalConfig.IEDriverInitalValue, globalConfig.IEDriverPath);
				System.out.println(" Windows OS Executing on Internet Explorer Browser");
				driver = new InternetExplorerDriver();
			}
		} else if (System.getProperty("os.name").contains("nux") || System.getProperty("os.name").contains("nix")) {
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty(globalConfig.chromefoxDriverInitalValue, globalConfig.chromeDriverPath);
				System.out.println(" Linux OS Executing on Chrome Browser");
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty(globalConfig.firefoxDriverInitalValue, globalConfig.firefoxDriverPath);
				System.out.println(" Windows OS  Executing on Firefox");
				driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase("ie")) {
				System.setProperty(globalConfig.IEDriverInitalValue, globalConfig.IEDriverPath);
				System.out.println(" Linux OS  Executing on Firefox Browser");
				driver = new InternetExplorerDriver();
			}
		}

		driver.manage().window().maximize();
		driver.get(GlobalConfigurations.getInstance().applicationURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
