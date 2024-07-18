package lumineoxTestCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import lumineoxrepository.LuminoexHomePage;
import lumineoxrepository.LuminoexLoginPage;


public class LuminoexloginPostiveSceneario extends Utility
{
	LuminoexHomePage objhome=new LuminoexHomePage();
	LuminoexLoginPage objlogin=new LuminoexLoginPage();

	
	ArrayList<String> username=dataread("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx","Sheet2",0);
	ArrayList<String> password=dataread("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx","Sheet2",1);
	
	String exphomeurl="https://www.luminoex.com/";
	
	@Test(priority=1)
	public void initbrowser()
	{
		driversetting();
	}

	@Test(priority=2)
	public void navigate()
	{
		starttestcase("Login Positive Sceneario");
		
		
		
		for(int i=0;i<=username.size();i++)
		{
			elementfinder(objhome.loginbutton).click();
			elementfinder(objlogin.email).sendKeys(username.get(i));
			elementfinder(objlogin.pass).sendKeys(password.get(i));
			elementfinder(objlogin.loginbutton).click();
			
			String actualurl=driver.getCurrentUrl();
			
			compare(exphomeurl,actualurl,"Login Successful with user " +username.get(i),
					"Login Failed with user " +username.get(i));
			
			try 
			{
				Thread.sleep(3000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			elementfinder(objhome.logout).click();
		}
		
	}

}
