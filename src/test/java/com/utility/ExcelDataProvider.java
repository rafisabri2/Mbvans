package com.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    XSSFWorkbook wb;
    XSSFSheet sheet;
    public ExcelDataProvider(String excelpath)
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
            ExcelDataProvider excel=new ExcelDataProvider(System.getProperty("user.dir")+"/TestData/ExportExcel.xlsx");
            String data=excel.getCellData(0, 0, 0);
            System.out.println("data is"+data);
        }
    }

