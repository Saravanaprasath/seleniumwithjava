package dexlock.inside.playground;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;


public class Basement {
    public static WebDriver driver = null;
    public static String browser = "chrome";
    public static String url = "http://testleaf.herokuapp.com/home.html";
    public static String homeUrl = "http://testleaf.herokuapp.com/";

    public Basement() {
        if (driver == null) {
            initDriver();
        }
    }

    public void initDriver() {
        browser = browser.toLowerCase();
        if (browser.contains("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        driver.get(url);
    }


}
