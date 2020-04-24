package com.poi.data;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ReadDataFromExcel(String excelpath)
	{
		File src=new File(excelpath);
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public String getCellData(int sheetnumber,int row,int column)
	{
		sheet=wb.getSheetAt(0);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
	public static void main(String args[])
	{
		ReadDataFromExcel excel=new ReadDataFromExcel("F://Test//Mbvans//src//test//java//data//ExcelPractice.xlsx");
		String data=excel.getCellData(0, 0, 0);
		System.out.println("data is"+data);
	}
}
