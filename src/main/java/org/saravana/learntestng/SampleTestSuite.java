package org.saravana.learntestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTestSuite {
    /*
     Aim :
        1. Open Chrome Browser & Go to google.co.in & Close the browser
        2. Open Chrome Browser & Go to bing.com & Close the browser
        3. Open Chrome Browser & Go to yahoo.co.in & Close the browser
     */
    WebDriver driver;
    @BeforeSuite
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }


    @Test
    public void openGoogleSearch() {
        long startTime = System.currentTimeMillis();
        driver.get("http://www.google.co.in");
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken "+totalTime);
    }

    @Test
    public void openBingSearch() {
        long startTime = System.currentTimeMillis();
        driver.get("https://www.bing.com/");
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken "+totalTime);
    }

    @Test
    public void openYahooSearch() {
        long startTime = System.currentTimeMillis();
        driver.get("https://in.yahoo.com/");
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken "+totalTime);
    }
}
