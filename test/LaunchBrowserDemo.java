package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowserDemo {
	
	WebDriver driver;
	
	void openbrowser() 
	{
	System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Setup\\Chrome Driver Setup\\chromedriver-win64\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	}
	
	void facebook() 
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("12345");
		driver.findElement(By.name("login")).click();
		
	}
	
	public static void main(String[] args) {
		
		LaunchBrowserDemo l=new LaunchBrowserDemo();
		l.openbrowser();
		l.facebook();
	}

}
