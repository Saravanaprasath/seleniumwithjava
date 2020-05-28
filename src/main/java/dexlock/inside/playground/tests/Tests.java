package dexlock.inside.playground.tests;

import dexlock.inside.playground.Basement;
import dexlock.inside.playground.pages.TestLeaf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tests extends Basement {
    TestLeaf testLeaf;
    public Tests() {
        testLeaf = PageFactory.initElements(driver, TestLeaf.class);
    }

    @Test
    public void calendar(){
        try {
            Thread.sleep(2000);
            testLeaf.goToCalendar();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clickOnCalendar() throws InterruptedException {
        testLeaf.clickOnDatePicker();
    }

    @Test
    @Parameters("nthday")
    public void clickOnNthDay(String nthday){
        testLeaf.clickOnNthDay(nthday);
    }

    @Test
    public void closeDriver() throws InterruptedException {
        driver.close();
    }

}
