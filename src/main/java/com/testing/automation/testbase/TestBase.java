package com.testing.automation.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class TestBase {
    public static WebDriver driver = null;
    public static String browser = "chrome";
    public static String url = "https://app.bidify.ai/";

    public TestBase() {
        if (driver == null) {
            initDriver();
        }
    }

    public static void initDriver() {
        if (browser.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        driver.get(url);
    }


    @AfterSuite
    public void closeBrowser() {
        driver.close();
    }
}
