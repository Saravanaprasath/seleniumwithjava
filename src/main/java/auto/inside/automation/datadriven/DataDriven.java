package auto.inside.automation.datadriven;

import auto.inside.automation.applications.coviddashboard.covid.CovidPage;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

public class DataDriven {
    Workbook wb;
    OutputStream ops;
    Sheet sheet;
    //HSSFRow row;
    CovidPage covidPage;

    @Test
    public void createWorkBook() throws IOException {
        try {
            wb = new HSSFWorkbook();
            ops = new FileOutputStream("data/saravana.xlsx");
            sheet = wb.createSheet("Corona");
            wb.write(ops);
            System.out.println("File and sheet created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    @Test
    public void createRow() {
        try {
            Map<String, ArrayList<String>> coronaDetails = CovidPage.putDataIntoMap();
            for (Map.Entry<String, ArrayList<String>> entry : coronaDetails.entrySet()) {
                String key = entry.getKey();
                ArrayList<String> values = entry.getValue();
                System.out.println("Key = " + key);
                System.out.println("Values = " + values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

}
