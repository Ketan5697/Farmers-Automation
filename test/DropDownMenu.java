package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownMenu {
	
	WebDriver driver;
	
	void openchrome()
	{
		System.getProperty("webdriver.chrome.driver","F:\\Selenium\\Setup\\Chrome Driver Setup\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	void facebook()
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//u_0_0_QM"));
		
	}
	public static void main(String[] args) 
	{
		
	}
}
