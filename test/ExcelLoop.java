package test;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLoop {
	
	public void Excel()
	{
	
	try
	{
		FileInputStream f= new FileInputStream("F:\\Selenium\\Book1.xlsx\\");
		XSSFWorkbook work= new XSSFWorkbook(f);
		XSSFSheet sheet=work.getSheetAt(0);
		XSSFRow row=sheet.getRow(1);
		 
		int cell=row.getLastCellNum();
		
		for(int i=0;i<=cell;i++)
		{
			String text=row.getCell(i).getStringCellValue();
			System.out.println(text);
		}
		
		work.close();
		f.close();
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
public static void main(String[] args) 
	{
		ExcelLoop e= new ExcelLoop();
		e.Excel();
	}

}
