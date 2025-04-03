package com.Obsqura.rmartSupermarket.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Obsqura.rmartSupermarket.Constant.Constant;

public class ExcelDataUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	
	public static String getStringdata(int a,int b,String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.EXCELPATH);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
		
	}
	public static String getIntegerdata(int a,int b, String sheet) throws IOException
	{
		f=new FileInputStream(Constant.EXCELPATH);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		int y= (int) c.getNumericCellValue();//type casting
		return String.valueOf(y);
		
	}


}
