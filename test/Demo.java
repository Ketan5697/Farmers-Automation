package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	
	WebDriver driver;
	
	void Setting()
	{
		System.setProperty("Webdriver.chrome.driver","F:\\Selenium\\Setup\\Chrome Driver Setup\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	
public static void main(String[] args) {

	Demo d=new Demo();
	d.Setting();
}
	
}
