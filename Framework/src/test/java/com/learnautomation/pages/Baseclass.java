package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigdataProvider;
import com.learnautomation.utilities.ExceldataProvider;
import com.learnautomation.utilities.Helper;

public class Baseclass 
{
	
	public WebDriver driver;
	public ExceldataProvider excel;
	public ConfigdataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExceldataProvider();
		config=new ConfigdataProvider();
		
		ExtentSparkReporter extent=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM+"+Helper.currentDateTime()+".html"));
		reports=new ExtentReports();
		reports.attachReporter(extent);
		
	}
	
	//adding a comment
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
	}
	
	@AfterClass
	public void TearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			Helper.captureScreenShot(driver);
			logger.fail("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		reports.flush();
	}
	
	
	
}
