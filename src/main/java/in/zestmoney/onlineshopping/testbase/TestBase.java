package in.zestmoney.onlineshopping.testbase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public static WebDriver driver = null;
    public static String browser = "Chrome";

    public TestBase() {
        if (driver == null) {
            initDriver();
        }
    }

    public void initDriver(){
        browser = browser.toLowerCase();
        if(browser.contains("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
    }
}
