package framework;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestCase extends Utility
{
	ObjectRepository objrepo= new ObjectRepository();
	
	@Test (priority=1)
	public void initbrowser()
	{
		init();
		
	}
	@Test (priority=2)
	public void navigate()
	{
		elementfinder(objrepo.Userid).sendKeys("abcd");
		elementfinder(objrepo.Password).sendKeys("1234");
		elementfinder(objrepo.Login).click();
	}
	
}
