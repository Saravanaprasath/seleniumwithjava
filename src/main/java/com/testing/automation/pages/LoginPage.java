package com.testing.automation.pages;

import com.testing.automation.testbase.TestBase;
import com.testing.automation.wrapper.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TestBase {
    WebDriver driver;
    SeleniumWrapper se;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        se = new SeleniumWrapper(driver);
    }

    @FindBy(id = "normal_login_userEmail")
    WebElement userName;
    @FindBy(id = "normal_login_password")
    WebElement passWord;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;


    public void login() {
        userName.sendKeys("admin@bidify.ai");
        passWord.sendKeys("bidify");
        se.takeScreenshot();
        se.takeScreenshotWithUrl();
        submit.submit();


    }

    public void testing() {
        System.out.println("Hello world");
    }

}
