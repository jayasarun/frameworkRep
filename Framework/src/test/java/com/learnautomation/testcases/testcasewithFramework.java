package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcasewithFramework 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "L:\\Selenium Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://ui.cogmento.com/");
		Thread.sleep(10000L);
		driver.findElement(By.name("email")).sendKeys("arunjayas123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Testing@123");
		
		
	}

}
