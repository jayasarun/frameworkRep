package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigdataProvider 
{
	Properties pro;
	public ConfigdataProvider()
	{
		File src=new File("./Config/config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to Load the configuratin file >>"+e.getMessage());
		}
		
	}
	
	public String getDatafromConfig(String ketToSearch)
	{
		return pro.getProperty(ketToSearch);
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getURL()
	{
		return pro.getProperty("qaUrl");
	}
	
	
}
