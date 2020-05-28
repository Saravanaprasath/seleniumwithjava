package fb.messenger.automation.tests;

import fb.messenger.automation.BaseFaceBook;
import fb.messenger.automation.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTests extends BaseFaceBook {
    HomePage homePage;

    public HomePageTests() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void goToMessenger() {
        try {
            homePage.loginToFacebook();
            homePage.goToMessenger();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteChats() {
        try {
            homePage.deleteChat();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
