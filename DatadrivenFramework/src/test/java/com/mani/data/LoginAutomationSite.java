package com.mani.data;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginAutomationSite extends TestBase {
	String filePath = "G:\\Git_Repository\\Selenium-Advanced-Concepts\\DatadrivenFramework\\src\\test\\java\\com\\mani\\data\\excel\\TestData.xlsx";

	@DataProvider(name = "testData")
	public Object[][] dataSource() {
		return getData(filePath, "test");
	}

	@Test(priority = 1, dataProvider = "testData")
	public void doLogin(String username, String password) throws Exception {

		System.out.println("variable1:-" + username);
		System.out.println("variable2:-" + password);

		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
//		Thread.sleep(30000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='passwd']"));

		userNameField.clear();
		passwordField.clear();

		userNameField.sendKeys(username);
		passwordField.sendKeys(password);

		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
		
	}
	
//	@Test(dependsOnMethods = "doLogin")
//	@Test(priority = 2)
//	public void doLogOut() {
//		
//	}
	
}
