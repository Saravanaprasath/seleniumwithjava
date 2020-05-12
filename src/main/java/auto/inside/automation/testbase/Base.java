package auto.inside.automation.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class Base {
    public static WebDriver driver = null;
    public static String browser = "chrome";
    public static String url = "https://www.google.com/";

    public Base() {
        if (driver == null) {
            initDriver();
        }
    }

    public void initDriver() {
        browser = browser.toLowerCase();
        if (browser.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.contains("firefox")) {
            System.setProperty("webdriver.chrome.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    //@AfterSuite
    public void closeBrowser() {
        driver.close();
    }
}
