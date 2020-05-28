package com.testing.javaprogramming.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class WriteDataInExcel {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFRow row;
    OutputStream ops;

    public WriteDataInExcel(String filePathAndName, String sheetName) throws Exception {
        workbook = new XSSFWorkbook();
        ops = new FileOutputStream(filePathAndName);
        sheet = workbook.createSheet(sheetName);

    }

    public void writeIntoSheet(Map<String, ArrayList<String>> dataMap) throws IOException {
        int rowId = 0;
        Set<String> keyId = dataMap.keySet();
        for (String key : keyId) {
            row = sheet.createRow(rowId++);
            ArrayList<String> data = dataMap.get(key);
            int cellid = 0;
            for (Object obj : data) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }
        workbook.write(ops);
        ops.close();
    }


}
