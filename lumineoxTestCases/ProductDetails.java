package lumineoxTestCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import lumineoxrepository.LuminoexHomePage;
import lumineoxrepository.LuminoexLoginPage;
import lumineoxrepository.MobileModule;
import lumineoxrepository.OnePlus;



public class ProductDetails extends Utility
{
	LuminoexHomePage objhomerepo=new LuminoexHomePage();
	LuminoexLoginPage objloginrepo=new LuminoexLoginPage();
	MobileModule objmobile=new MobileModule();
	OnePlus objoneplus=new OnePlus();
	
	ArrayList<String> productdetailsExp=dataread("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx","Sheet3",0);
	
	ArrayList<String> username=dataread("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx","Sheet2",0);
	ArrayList<String> password=dataread("E:\\Selenium\\Setup\\testexcel\\LuminoexExcel.xlsx","Sheet2",1);
	
	ArrayList<String> productdetailsActual= new ArrayList<String>();
	
	@Test(priority=1)
	public void initbrowser()
	{
		driversetting();
	}
	
	@Test(priority=2)
	public void login()
	{
		starttestcase("Verify the Product Details");
		
				
		for(int i=0;i<username.size();i++)
		{
			elementfinder(objhomerepo.loginbutton).click();
			elementfinder(objloginrepo.email).sendKeys(username.get(i));
			elementfinder(objloginrepo.pass).sendKeys(password.get(i));
			elementfinder(objloginrepo.loginbutton).click();
			
			markstatus("info","Testing the Product Details with user " +username.get(i));
			
			elementfinder(objhomerepo.MobileModule).click();
			elementfinder(objmobile.Andriod).click();
			try
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			elementfinder(objmobile.OnePlus).click();
			
			
			productdetailsActual.add(elementfinder(objoneplus.productname).getText());
			productdetailsActual.add(elementfinder(objoneplus.productdesc).getText());
			productdetailsActual.add(elementfinder(objoneplus.productprice).getText());
			
			for(int j=0;j<productdetailsExp.size();j++)
			{
				compare(productdetailsExp.get(j),productdetailsActual.get(j),
						"The value is displaying correctly " +productdetailsActual.get(j),
						"The value is not displaying correctly " +productdetailsActual.get(j));
				
			}
			
			productdetailsActual.clear();
			
			elementfinder(objoneplus.logout).click();
			
			
		}
	}

}
