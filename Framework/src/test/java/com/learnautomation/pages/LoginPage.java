package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(name="email") WebElement uname;
	
	@FindBy(name="password") WebElement pass;
	
	@FindBy(xpath="//*[text()=\"Login\"]") WebElement loginButton;
	
	public void LogintoCRM(String UsernameApplication, String PasswordApplication)
	{
		uname.sendKeys(UsernameApplication);
		pass.sendKeys(PasswordApplication);
		loginButton.click();
	}
	
}
