package com.testing.javaprogramming.excel;

import org.testng.annotations.Test;

import java.io.IOException;

import static com.testing.javaprogramming.excel.ReadDataFromExcel.*;

public class AccessExcel {
    ReadDataFromExcel readDataFromExcel;
    String filePath = "data/readdata.xlsx";
    String sheetName = "Company";

    @Test
    public void readDataFromExcel() throws IOException {
        readDataFromExcel = new ReadDataFromExcel(filePath, sheetName);
        int rowCount = getRowCount();
        int columnCount = getColumnCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                getCellData(i, j);
            }
        }
    }


}
