package lumineoxTestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import lumineoxrepository.LuminoexHomePage;
import lumineoxrepository.RegisterPage;

public class RegisterPositiveSceneario extends Utility
{
	LuminoexHomePage objhome=new LuminoexHomePage();
	RegisterPage objregister=new RegisterPage();
	
	@Test(priority=1)
	public void initbrowser()
	{
		driversetting();
	}
	
	public void navigate()
	{
		elementfinder(objhome.Register).click();
		elementfinder(objregister.Genderfemale).click();
		elementfinder(objregister.FirstName).sendKeys("kavita");
		elementfinder(objregister.LastName).sendKeys("trainer");
		
		//for selecting day from dropdown
				WebElement day=elementfinder(objregister.BirthDate);
				Select select=new Select(day);
				select.selectByIndex(23);
				
				//for selecting month from dropdown
				WebElement month=elementfinder(objregister.Month);
				Select select1=new Select(month);
				select1.selectByValue("10");
				
				//for selecting year from dropdown
				WebElement year=elementfinder(objregister.Year);
				Select select2=new Select(year);
				select2.selectByVisibleText("1986");
			
				elementfinder(objregister.Email).sendKeys("kav_teju@yahoo.com");	
				elementfinder(objregister.Company).sendKeys("YessInfotech");
				elementfinder(objregister.NewsLetter).click();
				elementfinder(objregister.Password).sendKeys("kavita@123");
				elementfinder(objregister.ConfPassword).sendKeys("kavita@123");
				elementfinder(objregister.RegisterButton).click();
	}

}
