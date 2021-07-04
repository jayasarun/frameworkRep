package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.Baseclass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ExceldataProvider;
import com.learnautomation.utilities.Helper;



public class LogintestCRM extends Baseclass
{
	ExceldataProvider excel=new ExceldataProvider();
	
	@Test
	public void loginApp()
	{
		
		logger=reports.createTest("Login to CRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		//Here we are passing the Username and password to login from the excel file.
		loginPage.LogintoCRM(excel.getStringdata("Login", 0, 0), excel.getStringdata("Login", 0, 1));
		logger.info("Logger Info part");
		
		Helper.captureScreenShot(driver);
		
		logger.pass("Logger pass part");
	}
	
	@Test
	public void loginApp1()
	{
		
		logger=reports.createTest("Logout to CRM");
		
		logger.info("Logger Info part");
		
		logger.fail("Logger fail part");
	}
	
	
}
