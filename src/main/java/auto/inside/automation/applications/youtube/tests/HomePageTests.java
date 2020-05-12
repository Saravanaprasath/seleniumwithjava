package auto.inside.automation.applications.youtube.tests;

import auto.inside.automation.testbase.Base;
import auto.inside.automation.applications.youtube.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTests extends Base {
    HomePage homePage;

    public HomePageTests() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    //Tests
    @Test
    public void searchInGoogle() {
        homePage.search();
        homePage.getAllSearchURLsGoToYoutube();
        homePage.searchInYouTube();
    }
/*
    @Test
    public void getTitles() {
        homePage.getAllYTVideoTitles();
        homePage.getAllYTChannelNames();
    }*/

    @Test
    public void printTitles() {
        homePage.printVideoTitleAndChannelName();
    }


}
