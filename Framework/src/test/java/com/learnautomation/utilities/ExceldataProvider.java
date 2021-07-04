package com.learnautomation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceldataProvider
{
	XSSFWorkbook wb;
	
	public ExceldataProvider()
	{
		try 
		{
			FileInputStream fis=new FileInputStream("./Testdata/Data.xlsx");
			wb=new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Sorry, we are unable to Read your excel file"+e.getMessage());
		}
	}
	
	public String getStringdata(String sheetName, int row, int col)
	{
		 return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	//Example of Method Overloading
	public String getStringdata(int sheetIndex, int row, int col)
	{
		 return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericdata(String sheetName, int row, int col)
	{
		 return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
