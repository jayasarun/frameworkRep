package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	WebDriver driver;
	
		public static WebDriver startApplication(WebDriver driver,String browserName, String Url)
		{
			if(browserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver=new ChromeDriver();
				
				
				
			}
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			driver.get(Url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
			
		}
		
		public static void quitBrowser(WebDriver driver)
		{
			driver.quit();
		
		}

	
}
