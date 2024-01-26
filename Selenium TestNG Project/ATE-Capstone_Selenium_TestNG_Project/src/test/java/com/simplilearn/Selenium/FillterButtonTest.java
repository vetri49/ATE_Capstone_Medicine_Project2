package com.simplilearn.Selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FillterButtonTest {

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
		if(driver!=null)
		driver.quit();
	}
	@Test(description="Test search product title match",priority=1)
	public void addCartPageTest() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("thavik@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Thavik@000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/form/button")).submit();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mynavbar\"]/ul/li[2]/a")).click();
		
	}
	@Test(description="Test search product  page source url",priority=2)
	public void addCartPageSOurceUrlTest() throws InterruptedException {
		Thread.sleep(2000);
//		driver.findElement(By.id("fillter-button")).click();
//		driver.findElement(By.id("lth")).click();
		String url=driver.getCurrentUrl();
		assertEquals("http://localhost:9010/orders",url);
	}
	@Test(description="Test search product page title ",priority=3)
	public void homePageTitleTest() {
		
		String actualTitle=" ";
		assertNotEquals(actualTitle,driver.getTitle());
		System.out.println(driver.getTitle());
	}

}
