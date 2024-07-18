package lumineoxTestCases;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Utility 
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest logger;
	public ExtentReports report;
	public WebDriver driver; //kind of object known as instant of interface
	   
    void driversetting()
	{
    	String browsername;
		String applicationlink;
		
		try
	{
		FileInputStream fs=new FileInputStream("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet objsheet=workbook.getSheetAt(0);
		XSSFRow row =objsheet.getRow(1);
		 browsername= row.getCell(0).getStringCellValue();
		 applicationlink=row.getCell(1).getStringCellValue();
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
		}
		else
		{
			//code to open firefox browser.
		}
		
		driver.get(applicationlink);
		workbook.close();
		fs.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}			
	}
	
	public WebElement elementfinder(By objby)
	{
		WebElement temp=driver.findElement(objby);
		return temp;
	}
	
	public  ArrayList<String> dataread(String filepath,String sheetname,int cellno)
	{
		ArrayList<String> obja=new ArrayList<String>();
		try
		{
		
		FileInputStream fs=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet objsheet=workbook.getSheet(sheetname);
		int rowcount=objsheet.getLastRowNum();
		for(int a=1;a<=rowcount;a++)
		{
			XSSFRow row=objsheet.getRow(a);
			String temp=row.getCell(cellno).getStringCellValue();
			obja.add(temp);
		}
		workbook.close();
		fs.close();
	}
	
    catch(Exception e)
	{
		e.printStackTrace();			
		
	}
	 return obja;
}

	@BeforeSuite
	public void initreport()
	{
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		htmlReporter=new ExtentHtmlReporter("E:\\Selenium\\Setup\\ExtentsReports\\SampleReports\\LatestReport"+timeStamp+".html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
	}
	
	public void starttestcase(String Testcasename)
	{
		logger=report.createTest(Testcasename);
	}
	
	public void markstatus(String statusname,String description)
	{
		if(statusname.equalsIgnoreCase("PASS"))
		   {
			   logger.log(Status.PASS,description);
		   }
		   else if(statusname.equalsIgnoreCase("Fail"))
		   {
			   logger.log(Status.FAIL, description);				
		   }
		   else if(statusname.equalsIgnoreCase("info"))
		   {
			   logger.log(Status.INFO, description);				
		   }	
	}
	
	public void compare(String expected,String actual,String passmessage,String failmessage)
	{
		if(expected.equals(actual))
		{
			markstatus("pass",passmessage);
		}
		else
		{
			markstatus("fail",failmessage);
		}
	}
	
	@AfterSuite
	public void endreport()
	{
		report.flush();
	}
}
