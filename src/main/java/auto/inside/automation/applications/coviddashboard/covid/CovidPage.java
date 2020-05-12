package auto.inside.automation.applications.coviddashboard.covid;

import auto.inside.automation.testbase.Base;
import com.testing.automation.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
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

    public void getStateNames() throws InterruptedException {
        Thread.sleep(5000);
        ArrayList<String> stateNames = new ArrayList<>();
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

    public void getCount() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> confirmedCounts = new ArrayList<>();
        for (WebElement count : confirmedCount) {
            String c = count.getText();
            Thread.sleep(100);
            confirmedCounts.add(c);
        }
        ArrayList<String> activeCounts = new ArrayList<>();
        for (WebElement count : activeCount) {
            String c = count.getText();
            Thread.sleep(100);
            activeCounts.add(c);
        }
        ArrayList<String> recoveredCounts = new ArrayList<>();
        for (WebElement count : recoveredCount) {
            String c = count.getText();
            Thread.sleep(100);
            recoveredCounts.add(c);
        }
        ArrayList<String> deathCounts = new ArrayList<>();
        for (WebElement count : deathCount) {
            String c = count.getText();
            Thread.sleep(100);
            deathCounts.add(c);
        }
        System.out.println("confirmedCounts");
        System.out.println(confirmedCounts);
        System.out.println("activeCounts");
        System.out.println(activeCounts);
        System.out.println("recoveredCounts");
        System.out.println(recoveredCounts);
        System.out.println("deathCounts");
        System.out.println(deathCounts);
    }

}
