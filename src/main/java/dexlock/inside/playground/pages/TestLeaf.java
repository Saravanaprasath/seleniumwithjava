package dexlock.inside.playground.pages;

import dexlock.inside.playground.Basement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestLeaf extends Basement {
    WebDriver driver;

    public TestLeaf(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@href,'Calendar')]")
    WebElement calendar;
    @FindBy(id = "datepicker")
    WebElement datePicker;
    @FindBy(xpath = "//a[contains(@href,'Dropdown')]")
    WebElement dropDown;


    public void waitAndClick(WebElement element) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
            Thread.sleep(10000);
            ele.click();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void javascriptClick(WebElement element){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("","");
        } catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }

    //Calendars
    public void goToCalendar() throws InterruptedException {
        waitAndClick(calendar);
    }

    public void clickOnDatePicker() throws InterruptedException {
        waitAndClick(datePicker);
    }

    public void clickOnNthDay(String nthDay) {
        String nth = "//div[@id='ui-datepicker-div']//a[text()='" + nthDay + "']";
        driver.findElement(By.xpath(nth)).click();
    }

    //Dropdown
    public void goToDropDownPage() throws InterruptedException {
        waitAndClick(dropDown);
    }


}
