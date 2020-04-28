package com.testing.automation.excelwrapper;

import com.testing.automation.testbase.TestBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelWrapper extends TestBase {
    ArrayList<String> columnData;
    ArrayList<String> headingsKeys;
    WebDriver driver;
    ExcelWrapper ex;

    public ExcelWrapper(WebDriver driver) {
        this.driver = driver;
    }

    //General Methods
    public XSSFSheet getSheetDetails(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet;
    }

    public XSSFSheet getMySheet(String file, String sheet) throws IOException {
        XSSFSheet sh1 = getSheetDetails(file, sheet);
        return sh1;
    }

    public int getHeadingCount(String file, String sheet) throws IOException {
        int lastCellNumber = getMySheet(file, sheet).getRow(0).getLastCellNum();
        return lastCellNumber;
    }


    public ArrayList<String> getAllHeadingInSheet(String file, String sheet) throws IOException {
        XSSFRow heading = getMySheet(file, sheet).getRow(0);
        headingsKeys = new ArrayList<String>();
        for (int i = 0; i < getHeadingCount(file, sheet); i++) {
            String head = heading.getCell(i).toString();
            if (head.trim().equals("") || head.equals(null)) {
                break;
            }
            headingsKeys.add(head);
        }
        return headingsKeys;
    }

    public int getRowCountInSheet(String file, String sheet) throws IOException {
        int lastRowNumber = getMySheet(file, sheet).getLastRowNum();
        //System.out.println(lastRowNumber);
        return lastRowNumber;
    }

    public ArrayList<String> getAllDataInColumnByColumnIndex(int columnIndex, String file, String sheet) throws IOException {
        columnData = new ArrayList<String>();
        for (Row row : getMySheet(file, sheet)) {
            Cell cell = row.getCell(columnIndex);
            cell.setCellType(CellType.STRING);
            //System.out.println(cell.getStringCellValue());
            columnData.add(cell.getStringCellValue());
        }
        return columnData;
    }

    DataFormatter dataFormatter = new DataFormatter();

    public ArrayList<String> getAllDataInColumnByColumnName(String columnName, String file, String sheet) throws IOException {
        columnData = new ArrayList<String>();
        int noOfColumns = getMySheet(file, sheet).getRow(0).getLastCellNum();
        int rowsCount = getMySheet(file, sheet).getPhysicalNumberOfRows();
        System.out.println("Row Count" + rowsCount);
        System.out.println("Number of Columns" + noOfColumns);
        int dataColumnNumber = 0;
        for (int i = 0; i < noOfColumns; i++) {
            if (getMySheet(file, sheet).getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
                dataColumnNumber = getMySheet(file, sheet).getRow(0).getCell(i).getColumnIndex();
                System.out.println("Data column number " + dataColumnNumber);
            }
        }
        for (int i = 1; i < rowsCount; i++) {
            CellType type = getMySheet(file, sheet).getRow(i).getCell(dataColumnNumber).getCellType();
            Cell data = getMySheet(file, sheet).getRow(i).getCell(dataColumnNumber);
            String value = dataFormatter.formatCellValue(data);
            //String data = getMySheet(file, sheet).getRow(i).getCell(dataColumnNumber).getStringCellValue();
            columnData.add(value);
        }
        return columnData;
    }


    public ArrayList<ArrayList<String>> getRowData(String file, String sheet) throws IOException {
        int n = getRowCountInSheet(file, sheet);
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(n);
        for (int i = 1; i < n + 1; i++) {
            ArrayList<String> rowData = new ArrayList<String>();
            for (int j = 0; j < getHeadingCount(file, sheet); j++) {
                XSSFCell value = getMySheet(file, sheet).getRow(i).getCell(j);
                value.setCellType(CellType.STRING);
                String cellValue = value.getStringCellValue();
                rowData.add(cellValue);
            }
            data.add(rowData);
        }
        return data;
    }

    public List<Map<String, String>> getHeadingAndData(String file, String sheet) throws IOException {
        ArrayList heading = getAllHeadingInSheet(file, sheet);
        int rowCount = getRowCountInSheet(file, sheet);
        ArrayList<ArrayList<String>> data = getRowData(file, sheet);
        HashMap<String, String> excelHeadingAndValue;
        List<Map<String, String>> listOfData = new ArrayList<Map<String, String>>();
        for (int i = 0; i < rowCount; i++) {
            excelHeadingAndValue = new HashMap<String, String>(getHeadingCount(file, sheet));
            for (int j = 0; j < getHeadingCount(file, sheet); j++) {
                String head = heading.get(j).toString();
                String val = data.get(i).get(j);
                excelHeadingAndValue.put(head, val);
            }
            listOfData.add(excelHeadingAndValue);
        }
        return listOfData;
    }
}