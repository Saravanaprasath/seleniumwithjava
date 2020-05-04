package org.saravana.learntestng;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ParallelTesting {
    @Test
    public void openGoogle(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.co.in");
        driver.quit();
    }

    @Test
    public void openBing(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.quit();
    }

    @Test
    public void openYahoo(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://in.yahoo.com/");
        driver.quit();
    }
}
