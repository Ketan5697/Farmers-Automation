package test;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelAdd {
	
	WebDriver driver;
	
	public void Excel() 
	{
		try
		{
			FileInputStream file= new FileInputStream("F:\\Selenium\\Book1.xlsx");
			XSSFWorkbook work= new XSSFWorkbook(file);
			XSSFSheet sheet= work.getSheetAt(0);
			XSSFRow row=sheet.getRow(1);
			String value= row.getCell(1).getStringCellValue();
			
			System.out.println(value);
			
			work.close();
			file.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			
		ExcelAdd e= new ExcelAdd();
		e.Excel();

	}

}
