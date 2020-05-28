package com.testing.javaprogramming.excel;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadDataFromExcel {
    public static int rowCount;
    public static int columnCount;

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ReadDataFromExcel(String filePath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(filePath);
        sheet = workbook.getSheet(sheetName);
    }

    public static int getRowCount() {
        try {
            rowCount = sheet.getPhysicalNumberOfRows(); // get row count
            System.out.println("Row count : " + rowCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getColumnCount() {
        try {
            columnCount = sheet.getRow(0).getPhysicalNumberOfCells(); //get column count
            System.out.println("Column count : " + columnCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnCount;
    }


    public static void getCellData(int rowNum, int colNum) {
        try {
            String value = null;
            CellType type = sheet.getRow(rowNum).getCell(colNum).getCellType(); //Get Cell type
            String cellType = type.name(); //Prints the type of the cell "Numeric", "String", "Blank", etc
            if (cellType.contains("NUMERIC")) {
                value = NumberToTextConverter.toText(sheet.getRow(rowNum).getCell(colNum).getNumericCellValue()); //Convert numeric value to text and store into variable value
            }
            if (cellType.contains("STRING")) {
                value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue(); //Get string value and store into variable value
            }
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
