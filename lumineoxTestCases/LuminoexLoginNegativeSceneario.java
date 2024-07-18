package lumineoxTestCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import lumineoxrepository.LuminoexHomePage;
import lumineoxrepository.LuminoexLoginPage;

public class LuminoexLoginNegativeSceneario extends Utility
{
	LuminoexHomePage objhome=new LuminoexHomePage();
	LuminoexLoginPage objlogin=new LuminoexLoginPage();

	
	ArrayList<String> username=dataread("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx","Sheet4",0);
	ArrayList<String> password=dataread("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx","Sheet4",1);
	
	String experrormsg="Login was unsuccessful. Please correct the errors and try again.No customer account found";
	
	@Test(priority=1)
	public void initbrowser()
	{
		driversetting();
	}
	
	@Test(priority=2)
	public void navigate()
	{
		starttestcase("Login Negative Sceneario");
		
		
		
		for(int i=0;i<=username.size();i++)
		{
			elementfinder(objhome.loginbutton).click();
			elementfinder(objlogin.email).sendKeys(username.get(i));
			elementfinder(objlogin.pass).sendKeys(password.get(i));
			elementfinder(objlogin.loginbutton).click();
			
			String actualerrormsg=elementfinder(objlogin.incorrectdata).getText();
			
			
			compare(experrormsg,actualerrormsg,"Error Message generated is same as expected " ,
					"Error Message mismatch ");
			
			try 
			{
				Thread.sleep(3000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			elementfinder(objhome.logout).click();
		}
		
	}

}
