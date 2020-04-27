package com.testing.automation.tests;

import com.testing.automation.pages.LoginPage;
import com.testing.automation.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {
    LoginPage loginPage;

    public LoginPageTests() {
        super();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void login() {
        loginPage.login();
        loginPage.testing();
    }
}
