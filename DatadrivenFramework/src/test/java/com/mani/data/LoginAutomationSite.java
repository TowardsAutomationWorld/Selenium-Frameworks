package com.mani.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mani.data.utils.ReportUtil;

public class LoginAutomationSite extends TestBase {
	String filePath = "G:\\Git_Repository\\Selenium-Advanced-Concepts\\DatadrivenFramework\\src\\test\\java\\com\\mani\\data\\excel\\TestData.xlsx";
	FileInputStream orFile;
	Properties or;

	@DataProvider(name = "testData")
	public Object[][] dataSource() {
		return getData(filePath, "test");
	}

	@Test(priority = 1, dataProvider = "testData")
	public void doLogin(String username, String password) throws Exception {

		System.out.println("variable1:-" + username);
		System.out.println("variable2:-" + password);

		driver.findElement(getbjectLocator("signInButton")).click();
		// Thread.sleep(30000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement userNameField = driver.findElement(getbjectLocator("username"));
		WebElement passwordField = driver.findElement(getbjectLocator("password"));

		userNameField.clear();
		passwordField.clear();

		userNameField.sendKeys(username);
		passwordField.sendKeys(password);

		driver.findElement(getbjectLocator("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(getbjectLocator("signInButton")).click();
		
		ReportUtil.addKeyword("Login into Automattion Site", "Login", "Pass", null);
	}

	public By getbjectLocator(String locatorName) {

		try {
			orFile = new FileInputStream(
					"G:\\Git_Repository\\DatadrivenFramework\\src\\main\\java\\com\\mani\\data\\or\\or.properties");
			or = new Properties();
			or.load(orFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String locatorProperty = or.getProperty(locatorName);
		System.out.println(locatorProperty.toString());
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];

		By locator = null;
		switch (locatorType) {
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}
}
