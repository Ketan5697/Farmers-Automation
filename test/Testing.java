package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	

	public static void main(String[] args) {
		
		
		System.getProperty("WebDriver.chrome.driver", "F:\\Selenium\\Setup\\Chrome Driver Setup\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys("123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}

}
