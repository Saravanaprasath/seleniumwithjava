package dexlock.inside.playground.tests;

import dexlock.inside.playground.Basement;
import dexlock.inside.playground.pages.Dropdowns;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestDropDowns extends Basement {
    Dropdowns dropdowns;

    public TestDropDowns() {
        dropdowns = PageFactory.initElements(driver, Dropdowns.class);
    }


    @Test
    public void clickDropDown() throws Exception {
        dropdowns.goToDropDown();
    }
}
