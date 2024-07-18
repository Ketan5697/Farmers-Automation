package framework;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	
	WebDriver driver;
	
	void init()
	{
	String browser;
	String link;
	
	try
	{
		FileInputStream fs=new FileInputStream("F:\\Selenium\\Book1.xlsx\\");
		XSSFWorkbook book = new XSSFWorkbook(fs);
		XSSFSheet sheet= book.getSheetAt(1);
		XSSFRow row=sheet.getRow(1);
		
		browser=row.getCell(0).getStringCellValue();
		link=row.getCell(1).getStringCellValue();
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Setup\\Chrome Driver Setup\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else
		{
			
		}
		driver.manage().window().maximize();
		driver.get(link);
		book.close();
		fs.close();
}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	
	public WebElement elementfinder(By objby)
	{
		WebElement temp=driver.findElement(objby);
		return temp;
	}
}



