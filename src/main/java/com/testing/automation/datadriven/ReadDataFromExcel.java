package com.testing.automation.datadriven;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ReadDataFromExcel {
    //HashMap<String, ArrayList<String>> data = new HashMap<>();
    public void readData(String filePath, String fileName, String sheetName) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = null;
        Sheet sheet;
        int fileExtentionIndex = fileName.lastIndexOf(".");
        if (fileName.substring(fileExtentionIndex).equals(".xls")) {
            workbook = new HSSFWorkbook(fis);
        }
        if (fileName.substring(fileExtentionIndex).equals(".xlsx")) {
            workbook = new XSSFWorkbook(fis);
        }
        sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.iterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                System.out.println(cell.getStringCellValue());
            }
        }
    }

    @Test
    public void readFromExcel() throws IOException {
        String fileName = "logindata.xlsx";
        String filePath = System.getProperty("user.dir") + "\\data\\" + fileName;
        System.out.println(filePath);
        String sheetName = "Credentials";
        readData(filePath, fileName, sheetName);
    }
}
