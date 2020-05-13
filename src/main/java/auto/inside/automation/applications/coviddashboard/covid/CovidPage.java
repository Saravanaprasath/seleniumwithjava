package auto.inside.automation.applications.coviddashboard.covid;

import auto.inside.automation.datadriven.DataDriven;
import auto.inside.automation.testbase.Base;
import com.testing.automation.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CovidPage extends Base {
    WebDriver driver;
    public String covidUrl = "https://www.covid19india.org/";

    public CovidPage(WebDriver driver) {
        this.driver = driver;
    }

    //WebElements
    @FindBy(xpath = "//table[@class='table fadeInUp']//tbody//tr[@class='state']//span[@class='title-icon']")
    List<WebElement> stateName;
    @FindBy(xpath = "//table[@class='table fadeInUp']//tbody//tr[@class='state']//span[@class='delta is-confirmed']//following-sibling::span")
    List<WebElement> confirmedCount;
    @FindBy(xpath = "//table[@class='table fadeInUp']//tbody//tr[@class='state']//span[@class='delta is-active']//following-sibling::span")
    List<WebElement> activeCount;
    @FindBy(xpath = "//table[@class='table fadeInUp']//tbody//tr[@class='state']//span[@class='delta is-recovered']//following-sibling::span")
    List<WebElement> recoveredCount;
    @FindBy(xpath = "//table[@class='table fadeInUp']//tbody//tr[@class='state']//span[@class='delta is-deaths']//following-sibling::span")
    List<WebElement> deathCount;
    @FindBy(xpath = "//table[@class='table fadeInUp']//tbody//tr[@class='state']//span[@class='total']")
    List<WebElement> countInTable;

    //WebPages
    public void goToDashBoard() {
        driver.get(covidUrl);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    ArrayList<String> stateNames;

    public void getStateNames() throws InterruptedException {
        Thread.sleep(5000);
        stateNames = new ArrayList<>();
        for (WebElement state : stateName) {
            String st = state.getText();
            Thread.sleep(100);
            stateNames.add(st);
        }
        for (String str : stateNames) {
            Thread.sleep(100);
            System.out.println(str);
        }
    }

    ArrayList<String> confirmedCounts;
    ArrayList<String> activeCounts;
    ArrayList<String> recoveredCounts;
    ArrayList<String> deathCounts;

    public void getCount() throws InterruptedException {
        Thread.sleep(3000);
        confirmedCounts = new ArrayList<>();
        for (WebElement count : confirmedCount) {
            String c = count.getText();
            Thread.sleep(100);
            confirmedCounts.add(c);
        }
        activeCounts = new ArrayList<>();
        for (WebElement count : activeCount) {
            String c = count.getText();
            Thread.sleep(100);
            activeCounts.add(c);
        }
        recoveredCounts = new ArrayList<>();
        for (WebElement count : recoveredCount) {
            String c = count.getText();
            Thread.sleep(100);
            recoveredCounts.add(c);
        }
        deathCounts = new ArrayList<>();
        for (WebElement count : deathCount) {
            String c = count.getText();
            Thread.sleep(100);
            deathCounts.add(c);
        }
       /* System.out.println("confirmedCounts");
        System.out.println(confirmedCounts);
        System.out.println("activeCounts");
        System.out.println(activeCounts);
        System.out.println("recoveredCounts");
        System.out.println(recoveredCounts);
        System.out.println("deathCounts");
        System.out.println(deathCounts);*/
        putDataIntoMap();
    }

    public Map<String, ArrayList<String>> putDataIntoMap() {
        int size = confirmedCounts.size();
        Map<String, ArrayList<String>> coronaDetails = new HashMap<String, ArrayList<String>>();
        ArrayList<String> data;
        for (int i = 0; i < size; i++) {
            data = new ArrayList<>();
            data.add(confirmedCounts.get(i));
            data.add(activeCounts.get(i));
            data.add(recoveredCounts.get(i));
            data.add(deathCounts.get(i));
            //System.out.println(data);
            String state = stateNames.get(i);
            for (int j = 0; j < data.size(); j++) {
                coronaDetails.put(state, data);
            }
        }
        System.out.println(coronaDetails);
        return coronaDetails;
    }


    /*public void writeData() {
        try {
            Map<String, ArrayList<String>> coronaDetails = putDataIntoMap();
            for (Map.Entry<String, ArrayList<String>> entry : coronaDetails.entrySet()) {
                String key = entry.getKey();
                ArrayList<String> values = entry.getValue();
                System.out.println("Key = " + key);
                System.out.println("Values = " + values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


}
