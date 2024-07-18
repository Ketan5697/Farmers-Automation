package test;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet{
	
	public void excelDemo()

	{
	try {
		FileInputStream f= new FileInputStream("F:\\Selenium\\Book1.xlsx\\");
		XSSFWorkbook work= new XSSFWorkbook(f);
		XSSFSheet sheet=work.getSheetAt(0);
		
		int rowcount=sheet.getLastRowNum();
		for(int i=0;i<=rowcount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			int cellcount=row.getLastCellNum();
			
			for(int j=0;j<cellcount;j++)
			{
				String text1=row.getCell(j).getStringCellValue();
				System.out.println(text1);
			}
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
		ExcelSheet ex=new ExcelSheet();
		ex.excelDemo();
		
		

	}
}

