package auto.inside.automation.youtube.pages;

import auto.inside.automation.testbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.awt.*;
import java.util.*;
import java.util.List;


public class HomePage extends Base {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //WebElements
    @FindBy(name = "q")
    WebElement searchBox;
    @FindBy(xpath = "//div[@id='rso']//div[@class='rc']//div[@class='r']//div[@class='TbwUpd NJjxre']/ancestor::a")
    List<WebElement> searchUrls;
    //youtube
    @FindBy(xpath = "//form[@id='search-form']//div[@id='search-input']//input")
    WebElement ytSearch;
    @FindBy(xpath = "//button[@id='search-icon-legacy']")
    WebElement ytSearchButton;
    @FindBy(xpath = "//div[@id='primary']//div[@id='title-wrapper']//h3//a")
    List<WebElement> ytVideoTitle;
    @FindBy(xpath = "//div[@id='primary']//div[@id='title-wrapper']//h3//a/ancestor::div[@id='title-wrapper']//following::ytd-video-meta-block//yt-formatted-string//a")
    List<WebElement> ytVideoChennalName;

    //Methods
    public void search() {
        searchBox.sendKeys("youtube");
        searchBox.submit();
    }

    public void getAllSearchURLsGoToYoutube() {
        List<WebElement> urls = searchUrls;
        ArrayList<String> url = new ArrayList<>();
        String links = null;
        for (WebElement ele : urls) {
            links = ele.getAttribute("href");
            url.add(links);
        }
        for (String link : url) {
            if (link.equals("https://www.youtube.com/")) {
                driver.get(link);
                break;
            }
        }
    }

    public void searchInYouTube() {
        ytSearch.click();
        ytSearch.sendKeys("Hello world - Java");
        ytSearchButton.click();
    }

    public ArrayList<String> getAllYTVideoTitles() {
        List<WebElement> ytVideoTitles = ytVideoTitle;
        ArrayList<String> titles = new ArrayList<>();
        for (WebElement ytVideoTitle : ytVideoTitles) {
            String str = ytVideoTitle.getAttribute("title");
            System.out.println(str);
            titles.add(str);
        }
        return titles;
    }

    public ArrayList<String> getAllYTChannelNames() {
        List<WebElement> ytChennalNames = ytVideoChennalName;
        ArrayList<String> videoTitles = new ArrayList<>();
        for (WebElement ytChennalName : ytChennalNames) {
            String str = ytChennalName.getText();
            System.out.println(str);
            videoTitles.add(str);
        }
        return videoTitles;
    }

    public void printVideoTitleAndChannelName() {
        HashMap<String, String> videoTitleAndChannelName = new HashMap<>();
        ArrayList<String> videoTitle = getAllYTVideoTitles();
        ArrayList<String> channelName = getAllYTChannelNames();


        for (int j = 0; j < channelName.size(); j++) {
            videoTitleAndChannelName.put(videoTitle.get(j), channelName.get(j));
        }

        System.out.println(videoTitleAndChannelName);
        //System.out.println(Arrays.asList(videoTitleAndChannelName));
    }

}
