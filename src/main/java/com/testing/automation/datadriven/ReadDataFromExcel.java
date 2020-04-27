package com.testing.automation.datadriven;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadDataFromExcel {
    File file;
    FileInputStream fis;
    Workbook workbook = null;
    Sheet sheet;
    int numberOfRows;

    public void readData(String filePath, String fileName, String sheetName) {
        try {
            file = new File(filePath + "\\" + fileName);
            fis = new FileInputStream(file);
            String fileExtentionName = fileName.substring(fileName.indexOf("."));
            if (fileExtentionName.equals(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            }
            if (fileExtentionName.equals(".xls")) {
                workbook = new HSSFWorkbook(fis);
            }
            sheet = workbook.getSheet(sheetName);
            numberOfRows = sheet.getLastRowNum()-sheet.getFirstRowNum();
            //Read All Data
            for (int i=0;i<=numberOfRows;i++){
               Row row = sheet.getRow(i);
               for(int j=0;j<row.getLastCellNum();j++){
                   System.out.print(row.getCell(j).getStringCellValue()+" || ");
               }
               System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testing(){
        String filePath = System.getProperty("user.dir")+"\\data";
        readData(filePath,"logindata.xlsx","Credentials");
    }

}
