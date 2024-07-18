package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	
	WebDriver driver;
	
	void getup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.MINUTES);
		
	}
	
	void pathdemo() {
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys("1234567");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click(); //tagname[@attribute='value']
		
	}

	public static void main(String[] args) {
		
		XpathDemo x=new XpathDemo();
		x.getup();
		x.pathdemo();

	}

}
