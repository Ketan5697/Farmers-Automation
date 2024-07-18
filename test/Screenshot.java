package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
	public static void main(String[] args)  {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Setup\\Chrome Driver Setup\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(50,TimeUnit.SECONDS);
		
		TakesScreenshot ss= (TakesScreenshot) driver;
		
		File source =ss.getScreenshotAs(OutputType.FILE);
		
		String destinationpath= "C:\\Users\\KETAN PATIL\\OneDrive\\Desktop\\11.png";
		
		
		try
		{
			FileUtils.copyFile(source, new File(destinationpath));
			System.out.println("Screen shot saved to" +destinationpath);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.quit();
		
				
	}

	

}
