package com.simplilearn.Selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	WebDriver driver=null;
	String siteurl="http://localhost:9010/";
	String driverpath="drivers/windows/chromedriver.exe";
	
	@BeforeTest
	public  void setup() {

		System.setProperty("webdriver.chrome.driver", driverpath);
	 driver=new ChromeDriver();
		
		driver.get(siteurl);
	}
	@AfterTest
	public void cleanup() {
		driver.quit();
	}
	@Test(description="Test Medicare login page title match",priority=1)
	public void loginPageTitleTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("thavik@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Thavik@000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/form/button")).submit();
		
		String expectedTitle  = "";
		String actualTitle  = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
	@Test(description="Test Medicare login page source url",priority=2)
	public void loginPageSOurceUrlTest() {
		String url=driver.getCurrentUrl();
		assertEquals("http://localhost:9010/login",url);
	}
	@Test(description="Test Medicare login page title invalid match",priority=3)
	public void loginPageTitleTest2() {
		String actualTitle=" ";
		assertNotEquals(actualTitle,driver.getTitle());
	}


}
