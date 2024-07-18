package ExtentsReports;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTest 
{
	ExtentHtmlReporter htmlreporter;
	ExtentTest logger;
	ExtentReports report;
	WebDriver driver;
	
	@Test (priority=1)
	public void driversetting()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		String timeStamp=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		htmlreporter= new ExtentHtmlReporter("F:\\Selenium\\Setup\\Selenium Jars\\SampleReports\\LatestReport"+timeStamp+".html");
		report= new ExtentReports();
		report.attachReporter(htmlreporter);
	}
	
	@Test (priority=2)
	public void testAlert()
	{
		String expectedresult="Please enter a valid user name";
		
		logger=report.createTest("Basic popup testing");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		logger.log(Status.INFO, "Navigated to the page");
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		driver.findElement(By.name("proceed")).click();
		Alert objalert=driver.switchTo().alert();
		logger.log(Status.INFO, "alert generated successfully");
		String actualresult=objalert.getText();
		objalert.dismiss();
		driver.switchTo().defaultContent();
		logger.log(Status.INFO, "Alert dismissed successfully");
		
		if(expectedresult.equals(actualresult))
		{
			logger.log(Status.PASS, "Alert text message displayed as expected");
		}
		else
		{
			logger.log(Status.FAIL, "Alert message mismatched");
		}
		report.flush();	
	}
}
