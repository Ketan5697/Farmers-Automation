package lumineoxrepository;

import org.openqa.selenium.By;

public class LuminoexHomePage 
{
	
	public By Register=By.xpath("//a[starts-with(text(),'Register')]");
	public By loginbutton=By.xpath("//a[starts-with(text(),'Log in')]");
	public By logout=By.linkText("Log out");
	public By MobileModule=By.linkText("Mobiles");

}
