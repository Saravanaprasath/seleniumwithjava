package dexlock.inside.playground.pages;

import dexlock.inside.playground.Basement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns extends Basement {
    WebDriver driver;
    TestLeaf testLeaf;

    public Dropdowns(WebDriver driver) {
        this.driver = driver;
        testLeaf = new TestLeaf(driver);
    }

    //Xpaths
    @FindBy(xpath = "//a[contains(@href,'Dropdown')]")
    WebElement dropdown;
    @FindBy(id = "dropdown1")
    WebElement dropDown1;
    @FindBy(name = "dropdown2")
    WebElement dropDown2;
    @FindBy(name = "dropdown3")
    WebElement dropDown3;


    @FindBy(xpath = "//select[@id='dropdown1']//option[@selected='selected']")
    WebElement selectedInDropdown1;

    public void goToDropDown() throws Exception {
        testLeaf.waitAndClick(dropdown);
        //selectByIndex();
        //selectByText();
        selectByValue();
    }

    public void selectByIndex() throws Exception {
        Select select = new Select(dropDown1);
        String text = selectedInDropdown1.getText();
        select.selectByIndex(1);
        Thread.sleep(5000);
        select.selectByIndex(2);
        Thread.sleep(5000);
        select.selectByIndex(3);
        Thread.sleep(5000);
        select.selectByIndex(4);
    }

    public void selectByText() throws Exception {
        Select select = new Select(dropDown2);
        select.selectByVisibleText("Selenium");
        Thread.sleep(5000);
        select.selectByVisibleText("Appium");
        Thread.sleep(5000);
        select.selectByVisibleText("UFT/QTP");
        Thread.sleep(5000);
        select.selectByVisibleText("Loadrunner");
    }

    public void selectByValue() throws Exception {
        Select select = new Select(dropDown3);
        select.selectByValue("1");
        Thread.sleep(5000);
        select.selectByValue("2");
        Thread.sleep(5000);
        select.selectByValue("3");
        Thread.sleep(5000);
        select.selectByValue("4");
    }


}
