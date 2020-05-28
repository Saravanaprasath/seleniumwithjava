package fb.messenger.automation.pages;

import fb.messenger.automation.BaseFaceBook;
import in.zestmoney.onlineshopping.wrapper.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseFaceBook {
    WebDriver driver;
    SeleniumWrapper se;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "email")
    WebElement emailId;
    @FindBy(id = "pass")
    WebElement password;
    @FindBy(id = "loginbutton")
    WebElement loginBtn;
    @FindBy(xpath = "//ul[@aria-label='Conversation List']//li[1]")
    WebElement firstChat;
    @FindBy(xpath = "//ul[@aria-label='Conversation List']//li[1]//div[@aria-label='Conversation actions']")
    WebElement ConversationActions;
    @FindBy(xpath = "//ul[@role='menu']//li//span[text()='Delete']/ancestor::a[@role='menuitem']")
    WebElement deleteChat;
    @FindBy(xpath = "//div[@role='dialog']//button[text()='Delete']")
    WebElement delete;

    public void loginToFacebook() {
        try {
            Thread.sleep(5000);
            emailId.sendKeys("useremailid@email.com");
            password.sendKeys("userpassword");
            loginBtn.submit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToMessenger() {
        try {
            Thread.sleep(5000);
            driver.navigate().to("https://www.facebook.com/messages/t/");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void deleteChat() {
        try {
            while (firstChat.isDisplayed()) {
                Actions actions = new Actions(driver);
                Thread.sleep(2000);
                WebDriverWait wait1 = new WebDriverWait(driver, 10);
                WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@aria-label='Conversation List']//li[1]")));
                element1.click();
                actions.moveToElement(ConversationActions).click().build().perform();
                Thread.sleep(2000);
                actions.moveToElement(deleteChat).click(deleteChat).build().perform();
                WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Dialog content']//button[text()='Delete' and @class='_3quh _30yy _2t_ _3ay_ _5ixy']")));
                element2.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
