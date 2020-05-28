package com.testing.javaprogramming.excel;
import auto.inside.automation.applications.coviddashboard.covid.CovidPage;


import org.testng.annotations.Test;

import java.io.IOException;

import static com.testing.javaprogramming.excel.ReadDataFromExcel.*;

public class AccessExcel {
    ReadDataFromExcel readDataFromExcel;
    WriteDataInExcel writeDataInExcel;
    CovidPage covidPage;
    String fileName = "data/saravana.xlsx";
    String sheetName = "Sheet1";

    @Test
    public void readDataFromExcel() throws IOException {
        readDataFromExcel = new ReadDataFromExcel(fileName, sheetName);
        int rowCount = getRowCount();
        int columnCount = getColumnCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                getCellData(i, j);
            }
        }
    }

    @Test
    public void writeDataInExcel() throws Exception {
        writeDataInExcel = new WriteDataInExcel("data/testing.xlsx","hello");
        writeDataInExcel.writeIntoSheet(covidPage.putDataIntoMap());
    }


}
