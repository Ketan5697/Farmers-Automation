package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractise {
	
	WebDriver driver;
	
	void Openchrome() 
	{
		System.setProperty("Webdriver.chrome.driver", "F:\\Selenium\\Setup\\Chrome Driver Setup\\chromedriver-win64");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	void Openfb() 
	{
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.name("login")).click();	
	}

	public static void main(String[] args) {
		
		XpathPractise d=new XpathPractise();
		d.Openchrome();
		d.Openfb();

	}

}
