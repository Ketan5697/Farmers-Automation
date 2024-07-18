package lumineoxrepository;

import org.openqa.selenium.By;

public class LuminoexLoginPage
{
	public By email=By.id("Email");
	public By pass=By.id("Password");
	public By loginbutton=By.xpath("//input[@class='button-1 login-button']");
	public By incorrectdata=By.xpath("//div[@class='message-error validation-summary-errors']");

}
